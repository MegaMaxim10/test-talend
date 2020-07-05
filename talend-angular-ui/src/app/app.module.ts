import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatSortModule } from '@angular/material/sort';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatInputModule } from '@angular/material/input';
import { MatRadioModule } from '@angular/material/radio'; 
import { MatSelectModule } from '@angular/material/select';

import { HeaderComponent } from './components/header/header.component';
import { DataTablesComponent } from './components/data-tables/data-tables.component';

import { ApiService } from './services/api.service';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    DataTablesComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    MatTableModule,
    MatButtonModule,
    MatSortModule,
    MatPaginatorModule,
    MatInputModule,
    MatRadioModule,
    MatSelectModule
  ],
  providers: [ApiService],
  bootstrap: [AppComponent]
})
export class AppModule { }
