import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {RouterModule} from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AddTaskComponent } from './add-task/add-task.component';
import {HttpClientModule} from '@angular/common/http';
import { EditTaskComponent } from './edit-task/edit-task.component';
import {MainPageComponent} from './main-page/main-page.component';
import {AppRoutingModule} from './app-routing.module';
import {registerLocaleData} from '@angular/common';
import deLocale from '@angular/common/locales/en-DE';

registerLocaleData(deLocale, 'en-DE');

@NgModule({
  declarations: [
    AppComponent,
    MainPageComponent,
    AddTaskComponent,
    EditTaskComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
