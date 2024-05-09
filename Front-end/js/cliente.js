var url = "http://localhost:8080/api/v1/clientes/";

function listaClientes() {
    var capturarFiltro = document.getElementById("SearchName").value;
    var urlclientes = url;
    if (capturarFiltro != "") {
        urlclientes += "/busquedafiltro/" + capturarFiltro; // Corregido: Agrega '/' antes de 'busquedafiltro'
    }
    $.ajax({
        url: urlclientes,
        type: "GET",
        success: function (result) {
            console.log(result);

            var cuerpoTabla = document.getElementById("cuerpoTabla");

            cuerpoTabla.innerHTML = "";

            // Resto del código permanece igual

            for (var i = 0; i < result.length; i++) {
                let trRegistro = document.createElement("tr");
                trRegistro.classList.add(i % 2 === 0 ? "form-fielddd" : "form-fieldd");

                // Asignación de datos a las celdas de la tabla
                let celdaIdentificacion = document.createElement("td");
                let celdaTipoIdentificacion = document.createElement("td");
                let celdaNumeroIdentificacion = document.createElement("td");
                let celdaNombreCliente = document.createElement("td");
                let celdaApellidoCliente = document.createElement("td");
                let celdaCiudad = document.createElement("td");
                let celdaDireccion = document.createElement("td");
                let celdaTelefono = document.createElement("td");
                let celdaEstado = document.createElement("td");

                celdaIdentificacion.innerText = result[i]["id_cliente"];
                celdaTipoIdentificacion.innerText = result[i]["tipo_identificacion"];
                celdaNumeroIdentificacion.innerText = result[i]["identificacion"];
                celdaNombreCliente.innerText = result[i]["nombre_cliente"];
                celdaApellidoCliente.innerText = result[i]["apellido_cliente"];
                celdaCiudad.innerText = result[i]["ciudad"];
                celdaDireccion.innerText = result[i]["direccion"];
                celdaTelefono.innerText = result[i]["telefono"];
                celdaEstado.innerText = result[i]["estado"];


                // Añade las celdas a la fila
                trRegistro.appendChild(celdaIdentificacion);
                trRegistro.appendChild(celdaTipoIdentificacion);
                trRegistro.appendChild(celdaNumeroIdentificacion);
                trRegistro.appendChild(celdaNombreCliente);
                trRegistro.appendChild(celdaApellidoCliente);
                trRegistro.appendChild(celdaTelefono);
                trRegistro.appendChild(celdaDireccion);
                trRegistro.appendChild(celdaCiudad);
                trRegistro.appendChild(celdaEstado);

                // Añade la fila a la tabla
                cuerpoTabla.appendChild(trRegistro);
            }

        },
        error: function (error) {
            console.error("Error en la petición:", error); // Corregido: Muestra el error en la consola
            alert("Error en la petición: " + error.statusText); // Corregido: Muestra el mensaje de error en una alerta
        }
    });
}
