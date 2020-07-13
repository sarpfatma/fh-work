import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { extract } from '@app/i18n';
import { TransactionDetailComponent } from './transaction_detail.component';
import { Shell } from '@app/shell/shell.service';

const routes: Routes = [
  Shell.childRoutes([
    { path: '', redirectTo: '/transactions/:transactionId', pathMatch: 'full' },
    { path: 'transactions/:transactionId', component: TransactionDetailComponent, data: { title: extract('Transactions') } },
  ]),
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: [],
})
export class TransactionsRoutingModule {}
