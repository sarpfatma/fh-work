import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {ServiceWorkerModule} from '@angular/service-worker';
import {TranslateModule} from '@ngx-translate/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import {environment} from '@env/environment';
import {CoreModule} from '@core';
import {SharedModule} from '@shared';
import {AuthModule} from '@app/auth';
import {ShellModule} from './shell/shell.module';
import {AboutModule} from './about/about.module';
import {AppComponent} from './app.component';
import {AppRoutingModule} from './app-routing.module';
import {ReportModule} from "@app/report/report.module";
import {TransactionsModule} from "@app/transactions/transactions.module";
import {TransactionDetailModule} from "@app/transaction_detail/transaction_detail.module";

@NgModule({
  imports: [
    BrowserModule,
    ServiceWorkerModule.register('./ngsw-worker.js', {enabled: environment.production}),
    FormsModule,
    HttpClientModule,
    TranslateModule.forRoot(),
    NgbModule,
    CoreModule,
    SharedModule,
    ShellModule,
    ReportModule,
    TransactionsModule,
    TransactionDetailModule,
    AboutModule,
    AuthModule,
    AppRoutingModule, // must be imported as the last module as it contains the fallback route
  ],
  declarations: [AppComponent],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {
}
