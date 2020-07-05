import { Injectable } from '@angular/core';
import { TestStagiaire1 } from '../models/test-tagiaire1-data.model';
import { TestStagiaire2 } from '../models/test-tagiaire2-data.model';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  public apiBaseURI : string = 'http://localhost:8097/';
  constructor() { }

  public async getTestStagiaire1Data() : Promise<TestStagiaire1[]> {
    let data: TestStagiaire1[] = [];
    try {
      const response = await fetch(this.apiBaseURI + 'data/getteststagiaire1data');
      if (response.status === 200) {
          const jsonData = await response.json();
          data = jsonData as TestStagiaire1[];
      }
    } catch(e) {
      console.log(e);
    }
    return data;
  }

  public async getTestStagiaire2Data() : Promise<TestStagiaire2[]> {
    let data: TestStagiaire2[] = [];
    try {
      const response = await fetch(this.apiBaseURI + 'data/getteststagiaire2data');
      if (response.status === 200) {
          const jsonData = await response.json();
          data = jsonData as TestStagiaire2[];
      }
    } catch(e) {
      console.log(e);
    }
    return data;
  }
}
