import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {TechnologyEditComponent} from './technology-edit/technology-edit.component';
import {TechnologyDetailComponent} from './technology-detail/technology-detail.component';
import {TechnologyListComponent} from './technology-list/technology-list.component';

export const TECHNOLOGY_ROUTES: Routes = [
   { path: '', component: TechnologyListComponent},
   { path: 'neu', component: TechnologyEditComponent},
   { path: ':id', component: TechnologyDetailComponent},
   { path: ':id/bearbeiten', component: TechnologyEditComponent},
];


@NgModule({
  imports: [RouterModule.forChild(TECHNOLOGY_ROUTES)
  ],
  exports: [RouterModule]
})
export class TechnologyRoutingModule { }
