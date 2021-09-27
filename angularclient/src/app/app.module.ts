import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppRoutingModule} from './app-routing.module';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {AppComponent} from './app.component';
import {TutorialListComponent} from './tutorial-list/tutorial-list.component';
import {TutorialFormComponent} from './tutorial-form/tutorial-form.component';
import {TutorialService} from './service/tutorial-service.service';
import {RouterModule} from '@angular/router';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatTooltipModule} from "@angular/material/tooltip";
import {MatButtonModule} from "@angular/material/button";
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {WikisComponent} from './wikis/wikis.component';
import {MatSortModule} from "@angular/material/sort";
import {MatTabsModule} from "@angular/material/tabs";
import {WikiServiceService} from "./service/wiki-service.service";


@NgModule({
  declarations: [
    AppComponent,
    TutorialListComponent,
    TutorialFormComponent,
    WikisComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule,
    BrowserAnimationsModule,
    MatTooltipModule,
    MatButtonModule,
    NgbModule,
    MatSortModule,
    MatTabsModule
  ],
  providers: [TutorialService, WikiServiceService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
