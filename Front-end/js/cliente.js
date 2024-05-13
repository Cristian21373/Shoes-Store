var url = "http://localhost:8080/api/v1/clientes/";

function listaClientes() {
    // Método para listar los clientes
    // Se crea la petición AJAX
    var capturarFiltro = document.getElementById("SearchName").value;
    var urlLocal = url;
    if (capturarFiltro != "") {
        urlLocal += "busquedafiltro/" + capturarFiltro;
    }
    $.ajax({
        url: urlLocal,
        type: "GET",
        success: function (result) {
            console.log(result);

            var cuerpoTabla = document.getElementById("cuerpoTabla");
            // Se limpia el cuerpo de la tabla
            cuerpoTabla.innerHTML = "";
            // Se hace un ciclo que recorra el arreglo con los datos
            for (var i = 0; i < result.length; i++) {
                // Una etiqueta tr por cada registro
                var trRegistro = document.createElement("tr");
                var celdaIdentificacion = document.createElement("td");
                var celdaTipoIdentificacion = document.createElement("td");
                var celdaNumeroIdentificacion = document.createElement("td");
                var celdaNombreCliente = document.createElement("td");
                var celdaApellidoCliente = document.createElement("td");
                var celdaCiudad = document.createElement("td");
                var celdaDireccion = document.createElement("td");
                var celdaTelefono = document.createElement("td");
                var celdaEstado = document.createElement("td");
                var celdaAcciones = document.createElement("td");

                var headerAcciones = document.getElementById("headerAcciones");

                var botonEditarCliente = document.createElement("button");
                botonEditarCliente.innerText = "Editar";
                botonEditarCliente.onclick = function () {
                    $('#exampleModal').modal('show');
                    consultarClienteID(result[i]["id_cliente"]);
                };
                botonEditarCliente.className = "btn btn-warning editar_cliente";

                var botonEliminar = document.createElement("button");
                botonEliminar.innerText = "Eliminar";
                botonEliminar.onclick = function () {
                    $('#exampleModal').modal('show');
                    consultarClienteID(result[i]["id_cliente"]);
                };
                botonEliminar.className = "btn btn-danger eliminar";

                var botonCambiar_estado = document.createElement("button");
                botonCambiar_estado.innerText = "Estado";
                botonCambiar_estado.onclick = function () {
                    $('#exampleModal').modal('show');
                    consultarClienteID(result[i]["id_cliente"]);
                };
                botonCambiar_estado.className = "btn btn-primary cambiar_estado";

                // Crear un contenedor div para los botones
                var divBotones = document.createElement("div");
                divBotones.className = "btn-group"; // Agregar la clase btn-group para que los botones estén en línea

                // Agregar los botones al contenedor div
                divBotones.appendChild(botonEditarCliente);
                divBotones.appendChild(botonEliminar);
                divBotones.appendChild(botonCambiar_estado);

                // Agregar el contenedor de botones a la celda de acciones
                celdaAcciones.appendChild(divBotones);


                celdaIdentificacion.innerText = result[i]["id_cliente"];
                celdaTipoIdentificacion.innerText = result[i]["tipo_identificacion"];
                celdaNumeroIdentificacion.innerText = result[i]["identificacion"];
                celdaNombreCliente.innerText = result[i]["nombre_cliente"];
                celdaApellidoCliente.innerText = result[i]["apellido_cliente"];
                celdaCiudad.innerText = result[i]["ciudad"];
                celdaDireccion.innerText = result[i]["direccion"];
                celdaTelefono.innerText = result[i]["telefono"];
                celdaEstado.innerText = result[i]["estado"];

                trRegistro.appendChild(celdaIdentificacion);
                trRegistro.appendChild(celdaTipoIdentificacion);
                trRegistro.appendChild(celdaNumeroIdentificacion);
                trRegistro.appendChild(celdaNombreCliente);
                trRegistro.appendChild(celdaApellidoCliente);
                trRegistro.appendChild(celdaTelefono);
                trRegistro.appendChild(celdaDireccion);
                trRegistro.appendChild(celdaCiudad);
                trRegistro.appendChild(celdaEstado);
                trRegistro.appendChild(celdaAcciones);

                cuerpoTabla.appendChild(trRegistro);
            }
        },
        error: function (error) {
            console.error("Error en la petición:", error);
            alert("Error en la petición: " + error.statusText);
        }
    });
}

function registrarClientes() {
    let formData = {
        "tipo_identificacion": document.getElementById("tipo_identificacion").value,
        "identificacion": document.getElementById("identificacion").value,
        "nombre_cliente": document.getElementById("nombre_cliente").value,
        "apellido_cliente": document.getElementById("apellido_cliente").value,
        "telefono": document.getElementById("telefono").value,
        "direccion": document.getElementById("direccion").value,
        "ciudad": document.getElementById("ciudad").value,
        "estado": document.getElementById("estado").value
    };

    // Validar número de identificación
    if (!validarNumeroIdentificacion(formData.identificacion.trim())) {
        Swal.fire({
            title: "Error",
            text: "El número de identificación debe contener solo números.",
            icon: "error"
        });
        return;
    }

    // Verificar que la longitud del número de identificación no exceda los 11 dígitos
    if (formData.identificacion.trim().length > 11) {
        Swal.fire({
            title: "Error",
            text: "El número de identificación debe ser de 11 digitos.",
            icon: "error"
        });
        return;
    }

    // Validar teléfono
    if (!validarTelefono(formData.telefono.trim())) {
        Swal.fire({
            title: "Error",
            text: "El teléfono debe contener solo números.",
            icon: "error"
        });
        return;
    }

    $.ajax({
        url: url,
        type: "POST",
        data: formData,
        success: function (result) {
            Swal.fire({
                title: "¡Excelente!",
                text: "Se guardó correctamente",
                icon: "success"
            });
            limpiarCliente();
        },
        error: function (error) {
            Swal.fire({
                title: "Error",
                text: "Ocurrió un error al guardar el cliente. Por favor, inténtelo de nuevo.",
                icon: "error"
            });
        },
    });
}

function validarNumeroIdentificacion(numero) {
    // Expresión regular que valida que el número de identificación sea numérico
    var regex = /^[0-9]+$/;
    return regex.test(numero);
}

function validarTelefono(telefono) {
    // Expresión regular que valida que el teléfono sea numérico
    var regex = /^[0-9]+$/;
    return regex.test(telefono);
}
