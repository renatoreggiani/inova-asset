import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {catchError, delay, Observable, of, throwError} from "rxjs";
import {Fundo} from "../models/Fundo";

@Injectable({
  providedIn: 'root'
})
export class ApiBackendService {
  api: string = 'http://localhost:4200/api/fundo/';

  constructor(private http: HttpClient) {
  }

  public getBuscarFundosPorPerfil(perfil?: any): Observable<Fundo[]> {
    const url = `${this.api}${perfil}`;

    return this.http.get<Fundo[]>(url).pipe(
      catchError(e => {
        return throwError(e);
      }));
  }


}
