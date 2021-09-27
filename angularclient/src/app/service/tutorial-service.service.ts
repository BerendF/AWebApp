import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Tutorial} from '../model/tutorial';
// @ts-ignore
import {Observable} from 'rxjs';

@Injectable()
export class TutorialService {

  private tutUrl: string;

  constructor(private http: HttpClient) {
    this.tutUrl = 'http://localhost:8080/tutorials';
  }

  public findAll(): Observable<Tutorial[]> {
    return this.http.get<Tutorial[]>(this.tutUrl);
  }

  public save(user: Tutorial) {
    return this.http.post<Tutorial>(this.tutUrl, user);
  }
}
