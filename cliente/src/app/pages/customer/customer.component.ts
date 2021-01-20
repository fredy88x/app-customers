import { DataSource } from '@angular/cdk/table';
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material';
import { Observable } from 'rxjs';
import { CustomersService } from 'src/app/services/customers.service';
import {Customer} from '../../models/customer.model'

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  dataSource = new CustomerDataSource(this.customerService);
  displayedColumns = ['sharedKey', 'name', 'email', 'phone', 'startDate', 'endDate'];
  constructor(private customerService:CustomersService) { }

  ngOnInit() {
    
  }

}

export class CustomerDataSource extends DataSource<Customer>{
  constructor(private customerService:CustomersService){
    super();
  }
  connect():Observable<Customer[]>{
    return this.customerService.obtenerListaCustomers();
  }
  disconnect(){}
}
