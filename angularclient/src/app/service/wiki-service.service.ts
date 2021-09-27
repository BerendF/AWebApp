import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Wiki} from '../model/wiki';
// @ts-ignore
import {Observable} from 'rxjs';

@Injectable()
export class WikiServiceService {

  private url: string;

  constructor(private http: HttpClient) {
    this.url = 'http://localhost:8080/wikis';
  }

  public findAll(): Observable<Wiki[]> {
    return this.http.get<Wiki[]>(this.url);
  }

  public save(user: Wiki) {
    return this.http.post<Wiki>(this.url, user);
  }
}
