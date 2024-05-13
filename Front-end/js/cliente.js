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

  
  if (formData.tipo_identificacion.trim() === "") {
      
      Swal.fire({
          title: "Error",
          text: "Por favor, seleccione un tipo de identificación.",
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



function validartipo_identificacion(celdatipo_identificacion) {
    var valor = celdatipo_identificacion.value;
    var valido = valor !== ""; 
    if (!valido) {

        alert("Por favor, seleccione un tipo de documento.");
    }
    actualizarClaseValidacion(celdatipo_identificacion, valido);
    return valido;
}
