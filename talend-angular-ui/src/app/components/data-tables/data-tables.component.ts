import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';

import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-data-tables',
  templateUrl: './data-tables.component.html',
  styleUrls: ['./data-tables.component.css']
})
export class DataTablesComponent implements OnInit {

  // Declaring table data and columns

  public data: MatTableDataSource<any>;
  public displayedColumns: string[] = [];
  public displayedColumnsTitles: any;
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

  public stagiaire1ColumnsToDisplay : string[] = [
    'raisonSociale',
    'nbresDemployesNomEntreprise',
    'nomEtPrenomDuResponsable',
    'contact',
    'situationGeographique',
    'votreExistantFixeMobileInternetCug',
    'observation'
  ];

  public stagiaire1ColumnsTitles : any = {
    raisonSociale: 'RAISON SOCIALE',
    nbresDemployesNomEntreprise: 'Nbres Demployes / Nom Entreprise',
    nomEtPrenomDuResponsable: 'Nom et Prenom du Responsable',
    contact: 'CONTACT',
    situationGeographique: 'Situation Geographique',
    votreExistantFixeMobileInternetCug: 'Votre existant (Fixe, Mobile Internet, CUG)',
    observation: 'OBSERVATION'
  };

  public stagiaire2ColumnsToDisplay : string[] = [
    'entreprise',
    'telephone',
    'email',
    'regionProvince',
    'flotte'
  ];
  
  public stagiaire2ColumnsTitles : any = {
    entreprise: 'Entreprise',
    telephone: 'Téléphone',
    email: 'Email',
    regionProvince: 'Région/Province',
    flotte: 'Flotte?'
  };

  constructor(private apiService: ApiService) { }

  // Initializations
  ngOnInit(): void {
    this.initializeDataSources();
    this.initializeTable();
  }

  public initializeTable() {
    this.apiService.getTestStagiaire1Data().then((dat) => {
      this.displayedColumnsTitles = this.stagiaire1ColumnsTitles;
      this.data = new MatTableDataSource(dat);
      this.columnsToDisplay = this.stagiaire1ColumnsToDisplay;
      this.displayedColumns = this.columnsToDisplay.slice();
      this.initializePaginationAndSorting();
    });
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
    this.apiService.getTestStagiaire2Data().then((dat) => {
      this.displayedColumnsTitles = this.stagiaire2ColumnsTitles;
      this.data = new MatTableDataSource(dat);
      this.columnsToDisplay = this.stagiaire2ColumnsToDisplay;
      this.displayedColumns = this.columnsToDisplay.slice();
      this.initializePaginationAndSorting();
      this.tableCaption = 'Test Stagiaire 2'
    });
  }

  // Set Test Stagiaire 1 data in the table
  public setTestStagiaire1DataSource() {
    this.apiService.getTestStagiaire1Data().then((dat) => {
      this.displayedColumnsTitles = this.stagiaire1ColumnsTitles;
      this.data = new MatTableDataSource(dat);
      this.columnsToDisplay = this.stagiaire1ColumnsToDisplay;
      this.displayedColumns = this.columnsToDisplay.slice();
      this.initializePaginationAndSorting();
      this.tableCaption = 'Test Stagiaire 1';
    });
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
