import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';

import * as dataSource from 'src/app/data-tables/data/table-data'

@Component({
  selector: 'app-data-tables',
  templateUrl: './data-tables.component.html',
  styleUrls: ['./data-tables.component.css']
})
export class DataTablesComponent implements OnInit {

  // Declaring table data and columns

  public data: MatTableDataSource<any>;
  public displayedColumns: string[] = [];
  public columnsToDisplay: string[] = [];

  // Data sources
  public dataSources: any[] = [];

  // Declaring variable for filter
  public searchValue: string = '';

  // Selected data source
  public selectedDataSource: string = '1';

  // Declaring variable caption
  public tableCaption: string = 'Test Stagiaire 1';

  // Declaring pagination and sorting modules

  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: true }) sort: MatSort;

  constructor() { }

  // Initializations
  ngOnInit(): void {
    this.initializeDataSources();
    this.initializeTable();
    this.initializePaginationAndSorting();
  }

  public initializeTable() {
    this.data = new MatTableDataSource(dataSource.TEST_STAGIAIRE_1_ARRAY);
    this.columnsToDisplay = dataSource.COLUMNS_TO_DISPLAY_FOR_TEST_STAGIAIRE_1_TABLE;
    this.displayedColumns = this.columnsToDisplay.slice();
  }

  public initializePaginationAndSorting() {
    this.data.paginator = this.paginator;
    this.data.sort = this.sort;
  }

  public initializeDataSources() {
    this.dataSources = [
      { name: 'Test Stagiaire 1' },
      { name: 'Test Stagiaire 2' }
    ];
  }

  // Set Test Stagiaire 2 data in the table
  public setTestStagiaire2DataSource() {
    this.data = new MatTableDataSource(dataSource.TEST_STAGIAIRE_2_ARRAY);
    this.columnsToDisplay = dataSource.COLUMNS_TO_DISPLAY_FOR_TEST_STAGIAIRE_2_TABLE;
    this.displayedColumns = this.columnsToDisplay.slice();
    this.initializePaginationAndSorting();
    this.tableCaption = 'Test Stagiaire 2'
  }

  // Set Test Stagiaire 1 data in the table
  public setTestStagiaire1DataSource() {
    this.data = new MatTableDataSource(dataSource.TEST_STAGIAIRE_1_ARRAY);
    this.columnsToDisplay = dataSource.COLUMNS_TO_DISPLAY_FOR_TEST_STAGIAIRE_1_TABLE;
    this.displayedColumns = this.columnsToDisplay.slice();
    this.initializePaginationAndSorting();
    this.tableCaption = 'Test Stagiaire 1';
  }

  public chooseDatasource() {
    switch (this.selectedDataSource) {
      case '1':
        this.setTestStagiaire1DataSource();
        break;
      case '2':
        this.setTestStagiaire2DataSource();
      default:
        break;
    }
  }

  // Filter table
  public applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.data.filter = filterValue.trim().toLowerCase();

    if (this.data.paginator) {
      this.data.paginator.firstPage();
    }
  }

  // Clear search input
  public clear() {
    this.searchValue = '';
    this.data.filter = '';

    if (this.data.paginator) {
      this.data.paginator.firstPage();
    }
  }
}
