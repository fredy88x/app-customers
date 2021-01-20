import { NgModule } from "@angular/core";
import { MatTableModule } from "@angular/material";

export const MAT_MODULES = [
    MatTableModule
]

@NgModule({
    declarations:[],
    exports: MAT_MODULES,
    imports: MAT_MODULES
})

export class MaterialComponentsModule {}

