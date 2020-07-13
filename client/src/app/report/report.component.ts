import {Component, OnInit} from '@angular/core';
import {finalize} from 'rxjs/operators';
import {ReportService} from './report.service';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.scss'],
})
export class ReportComponent implements OnInit {
  currencies: [any] | undefined;
  totalItem: undefined;
  isLoading = false;
  filterForm!: FormGroup;

  constructor(private reportService: ReportService, private formBuilder: FormBuilder) {
    this.createForm();
  }

  ngOnInit() {
    this.get();
  }

  get() {

    this.isLoading = false;

    const get$ = this.reportService.getReport(this.filterForm.value);

    get$
      .pipe(
        finalize(() => {
          this.isLoading = false;
        })
      )
      .subscribe((response: any) => {
        this.currencies = response.currencies;
        this.totalItem = response.total;
      });
  }

  private createForm() {
    this.filterForm = this.formBuilder.group({
      fromDate: [new Date(), Validators.required],
      toDate: [new Date(), Validators.required],
      merchantId: [null],
      acquirerId: [null],

    });
  }
}
