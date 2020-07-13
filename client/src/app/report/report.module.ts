import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TranslateModule } from '@ngx-translate/core';

import { CoreModule } from '@core';
import { SharedModule } from '@shared';
import { ReportRoutingModule } from './report-routing.module';
import { ReportComponent } from './report.component';
import { ReportService } from './report.service';
import {ReactiveFormsModule} from "@angular/forms";

@NgModule({
  imports: [CommonModule, TranslateModule, CoreModule, SharedModule, ReportRoutingModule, ReactiveFormsModule],
  declarations: [ReportComponent],
})
export class ReportModule {}
