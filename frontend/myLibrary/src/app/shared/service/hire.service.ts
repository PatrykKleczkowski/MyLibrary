import {Injectable} from '@angular/core';
import {environment} from "@env/environment";
import {HttpClient} from "@angular/common/http";


const API_URL = environment.apiUrl;

@Injectable({
  providedIn: 'root'
})
export class HireService {

  constructor(private http: HttpClient) {
  }
}
