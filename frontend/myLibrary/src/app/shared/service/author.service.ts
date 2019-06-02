import {Injectable} from '@angular/core';
import {environment} from "@env/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Author} from "@shared/model/Author";

const API_URL = environment.apiUrl;


@Injectable({
  providedIn: 'root'
})
export class AuthorService {

  constructor(private http: HttpClient) {
  }

  getAllAuthors(): Observable<Author[]> {
    return this.http.get<Author[]>(`${API_URL}/authors`);
  }

  saveNewAuthor(firstName: string, lastName: string) {
    return this.http.post<any>(`${API_URL}/authors/addAuthor/`, {firstName, lastName})
  }


}


