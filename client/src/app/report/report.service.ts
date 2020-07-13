import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {map, catchError} from 'rxjs/operators';
import {CredentialsService} from "@app/auth";

const routes = {
  report: () => `/transactions/report`,
};

export interface ReportContext {
  fromDate?: Date;
  toDate?: Date;
  merchant?: Number;
  acquirer?: Number;
  token?: String;
}

@Injectable({
  providedIn: 'root',
})
export class ReportService {
  constructor(private httpClient: HttpClient, private credentialsService: CredentialsService) {
  }

  getReport(context: ReportContext): Observable<string> {
    const header = {
      headers: new HttpHeaders()
        .set('Authorization', `Bearer ${btoa(this.credentialsService.credentials.token)}`)
    }
    for (const [key, value] of Object.entries(context)) {
      if (value === 'null' || value === null) delete context[key];
    }

    return this.httpClient.post(routes.report(), context, header).pipe(
      map((body: any) => body),
      catchError(() => of('Error, could not load reports :-('))
    );
  }
}
