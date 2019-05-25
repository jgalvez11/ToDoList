import { IonicModule } from '@ionic/angular';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FormularioNuevoUsuarioComponent } from './formulario-nuevo-usuario/formulario-nuevo-usuario.component';
import { EditarUsuarioModalComponent } from './editar-usuario-modal/editar-usuario-modal.component';
import { VerUsuarioComponent } from './ver-usuario/ver-usuario.component';

@NgModule({
    imports: [
        IonicModule,
        CommonModule,
        FormsModule,
        ReactiveFormsModule
    ],
    exports: [FormularioNuevoUsuarioComponent, EditarUsuarioModalComponent, VerUsuarioComponent],
    entryComponents: [FormularioNuevoUsuarioComponent, EditarUsuarioModalComponent, VerUsuarioComponent],
    declarations: [FormularioNuevoUsuarioComponent, EditarUsuarioModalComponent, VerUsuarioComponent]
})
export class SharedComponentsModule { }