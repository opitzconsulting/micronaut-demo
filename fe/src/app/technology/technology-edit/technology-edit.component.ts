import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {TechnologyService} from '../technology.service';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Technology} from '../../technology.model';

@Component({
  selector: 'app-technology-edit',
  templateUrl: './technology-edit.component.html',
  styleUrls: ['./technology-edit.component.scss']
})
export class TechnologyEditComponent implements OnInit {
  technologyForm: FormGroup;
  notEmpty = false;
  private technologyIndex: number;

  private isNew = true;
  private technology: Technology;

  constructor(private technologyService: TechnologyService,
              private router: Router,
              private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    let technologyName = null;
    let technologyDescription = null;
    let technologyRelevance = null;
    let technologyRecommendation = null;
    let technologyComplexity = null;
    let technologyUrl = null;

    // TODO keine schöne Lösung => redundanter Code...
    this.activatedRoute.params.subscribe(
      params => {
          if (params.hasOwnProperty('id')) {
            this.isNew = false;
            this.technologyIndex = +params[`id`];
            console.log(this.technologyIndex);
            this.technologyService.getTechnology(this.technologyIndex)
              .subscribe(technology =>  {
                this.technology = technology;
                technologyName = this.technology.name;
                technologyDescription = this.technology.description;
                technologyRelevance = this.technology.relevance;
                technologyRecommendation = this.technology.recommendation;
                technologyComplexity = this.technology.complexity;
                technologyUrl = this.technology.url;
                this.technologyForm = new FormGroup({
                  name: new FormControl(technologyName, Validators.required),
                  description: new FormControl(technologyDescription, Validators.required),
                  relevance: new FormControl(technologyRelevance, Validators.required),
                  recommendation: new FormControl(technologyRecommendation, Validators.required),
                  complexity: new FormControl(technologyComplexity, Validators.required),
                  url: new FormControl(technologyUrl, Validators.compose([Validators.required,
                    Validators.pattern('(https?://)?([\\da-z.-]+)\\.([a-z.]{2,6})[/\\w .-]*/?')])),
                });
              });
            console.log(this.technology);
          } else {
            this.isNew = true;
            this.technology = null;
            this.technologyForm = new FormGroup({
              name: new FormControl(technologyName, Validators.required),
              description: new FormControl(technologyDescription, Validators.required),
              relevance: new FormControl(technologyRelevance, Validators.required),
              recommendation: new FormControl(technologyRecommendation, Validators.required),
              complexity: new FormControl(technologyComplexity, Validators.required),
              url: new FormControl(technologyUrl, Validators.compose([Validators.required,
                Validators.pattern('(https?://)?([\\da-z.-]+)\\.([a-z.]{2,6})[/\\w .-]*/?')])),
            });
          }
        }
      );

  }

  get name() { return this.technologyForm.get('name'); }

  get description() { return this.technologyForm.get('description'); }

  get relevance() { return this.technologyForm.get('relevance'); }

  get recommendation() { return this.technologyForm.get('recommendation'); }

  get complexity() { return this.technologyForm.get('complexity'); }

  get url() { return this.technologyForm.get('url'); }


  onSubmit() {
    if (this.technologyForm.valid) {
      const newTechnology = this.technologyForm.value;
      if (this.isNew) {
        this.technologyService.addTechnology(newTechnology)
          .subscribe(() => this.onNavigateBack());
      } else {
        // first change this.technology values before transfer
        this.technology.name = newTechnology.name;
        this.technology.description = newTechnology.description;
        this.technology.relevance = newTechnology.relevance;
        this.technology.recommendation = newTechnology.recommendation;
        this.technology.complexity = newTechnology.complexity;
        this.technologyService.editTechnology(this.technology)
          .subscribe(() => this.onNavigateBack());
      }
    } else {
      this.notEmpty = true;
    }
  }

  onCancel() {
    this.onNavigateBack();
  }

  onNavigateBack() {
    this.router.navigate(['/']);
  }

}

