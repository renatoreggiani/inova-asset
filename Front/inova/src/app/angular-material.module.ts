import {NgModule} from "@angular/core";
import {MatBottomSheetModule} from "@angular/material/bottom-sheet";
import {MatButtonModule} from "@angular/material/button";
import {MatButtonToggleModule} from "@angular/material/button-toggle";
import {MatDividerModule} from "@angular/material/divider";
import {MatTableModule} from "@angular/material/table";


@NgModule({
  imports: [
    MatButtonModule,
    MatButtonToggleModule,
    MatDividerModule,
    MatTableModule
  ],
  exports: [
    MatButtonModule,
    MatButtonToggleModule,
    MatDividerModule,
    MatTableModule
  ]
})
export class AngularMaterialModule {
}
