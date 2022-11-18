import {Component, Input, OnChanges, SimpleChanges} from '@angular/core';
import {Fundo} from "../../models/Fundo";
import {MatTableDataSource} from "@angular/material/table";

@Component({
  selector: 'app-fundos',
  templateUrl: './fundos.component.html',
  styleUrls: ['./fundos.component.scss']
})
export class FundosComponent {

  displayedColumns: string[] = ['codigo', 'nome', 'risco', 'dp'];
  dataSource: MatTableDataSource<Fundo> = new MatTableDataSource<Fundo>();

  @Input()
  set setResponse(data: Fundo[]) {
    if (data) {
      console.log(data)
      this.dataSource = new MatTableDataSource<Fundo>(data);
    }
  }

}
