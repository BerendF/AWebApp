import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {TutorialListComponent} from './tutorial-list/tutorial-list.component';
import {TutorialFormComponent} from './tutorial-form/tutorial-form.component';
import {WikisComponent} from "./wikis/wikis.component";

const routes: Routes = [
  {path: 'tutorials', component: TutorialListComponent},
  {path: 'addTutorial', component: TutorialFormComponent},
  {path: 'wiki', component: WikisComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
