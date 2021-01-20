import { HttpClientModule } from "@angular/common/http";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { MaterialComponentsModule } from "src/app/shared/material-components/material-components.module";
import { CustomerRoutingModule } from "./customer-routing.module";
import { CustomerComponent } from "./customer.component";

@NgModule({
    declarations: [CustomerComponent],
    imports:[CustomerRoutingModule,HttpClientModule, FormsModule, MaterialComponentsModule]
})
export class CustomerModule {}