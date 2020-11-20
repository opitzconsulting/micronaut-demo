import {Component, OnInit} from '@angular/core';
import {Technology} from '../../technology.model';
import {TechnologyService} from '../technology.service';
import {Router} from '@angular/router';
import {
  FormBuilder,
  FormGroup
} from '@angular/forms';

@Component({
  selector: 'app-technology-list',
  templateUrl: './technology-list.component.html',
  styleUrls: ['./technology-list.component.scss']
})
export class TechnologyListComponent implements OnInit {
  technologies: Technology[];
  allTechnologies: Technology[];
  filterActive = false;
  filterForm: FormGroup;
  // search Title from Header
  searchValue: string;

  constructor(private technologyService: TechnologyService, private router: Router, private fb: FormBuilder) { }

  ngOnInit() {
    this.technologyService.getTechnologies().subscribe(
      technologies => {
        this.technologies = technologies;
        this.allTechnologies = technologies;
        console.log('List update');
      }
    );
    this.filterForm = this.fb.group({
        relevance: null,
        recommendation: null,
        complexity: null,
      }
    );
    this.technologyService.currentSearch.subscribe(searchValue => this.searchValue = searchValue);
  }

  onSubmit() {
    const newFilter = this.filterForm.getRawValue();
    this.filterTechnologies(newFilter.relevance, newFilter.recommendation, newFilter.complexity);
    this.filterActive = true;
  }

  removeFilter() {
    this.technologies = this.allTechnologies;
    this.filterForm.reset();
    this.filterActive = false;
  }

  sort(value: number) {
    switch (value) {
      case 0:
        this.technologies.sort((a, b) =>
        a.relevance < b.relevance ? 1 : 0);
        break;
      case 1:
        this.technologies.sort((a, b) =>
          a.recommendation < b.recommendation ? 1 : 0);
        break;
      case 2:
        this.technologies.sort((a, b) =>
          a.complexity > b.complexity ? 1 : 0);
        break;
    }
  }

  filterTechnologies(relevance: number, recommendation: number, complexity: number) {
    const filteredTechnologies: Technology[] = [];
    for (const technology of this.technologies) {
      // check relevance
      if (relevance !== null && technology.relevance < relevance) {
        continue;
      }
      // check recommendation
      if (recommendation != null && technology.recommendation < recommendation) {
        continue;
      }
      // check complexity
      if (complexity != null && technology.complexity > complexity) {
        continue;
      }
      filteredTechnologies.push(technology);
    }
    this.technologies = filteredTechnologies;
  }


}

