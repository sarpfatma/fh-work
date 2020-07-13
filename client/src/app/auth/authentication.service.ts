import {Injectable} from '@angular/core';
import {Observable, of, throwError} from 'rxjs';

import {Credentials, CredentialsService} from './credentials.service';
import {HttpClient} from "@angular/common/http";
import {catchError, finalize, map} from "rxjs/operators";


export interface LoginContext {
  email: string;
  password: string;
  remember?: boolean;
}

const routes = {
  auth: () => `/login`,
};

/**
 * Provides a base for authentication workflow.
 * The login/logout methods should be replaced with proper implementation.
 */
@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {
  constructor(private credentialsService: CredentialsService, private httpClient: HttpClient) {
  }

  /**
   * Authenticates the user.
   * @param context The login parameters.
   * @return The user credentials.
   */
  login(context: LoginContext): Observable<any> {
    return this.httpClient.post(routes.auth(), {email: context.email, password: context.password})
  }

  /**
   * Logs out the user and clear credentials.
   * @return True if the user was logged out successfully.
   */
  logout(): Observable<boolean> {
    // Customize credentials invalidation here
    this.credentialsService.setCredentials();
    return of(true);
  }
}
