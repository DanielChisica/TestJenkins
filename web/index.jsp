<%-- 
    Document   : Login
    Created on : 13/03/2019, 10:04:47 AM
    Author     : JoseJoaquinOrtizJaim
--%>

<%@page import="davivienda.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!doctype html>

<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>App Davivienda!</title>
    </head>


    <body background=https://i.pinimg.com/originals/a7/37/e1/a737e1a3422af26b58da3099cc3baccf.jpg>
        <div class="container separador">
            <div class="row justify-content-center bg">
                <div class="card" style="width: 500px;">
                    <div class="card-body">
                        <img src="https://www.colconectada.com/wp-content/uploads/2015/06/davivienda.jpeg" class="img-fluid" alt="Responsive image">                        
                        <center>
                        <h5 class="card-title">Iniciar Sesión</h5>
                        </center>

                        <div >
                            <div class="form-group" >
                                <form action="sesion"> 
                                    <label for="exampleInputEmail1">Número de cédula</label>
                                    <input type="text" name= "cedula" class="form-control"  id="inputcc" placeholder="Cédula" maxlength="10" onkeypress="return soloNumeros(event);">

                                    <label for="exampleInputPassword1">Contraseña</label>
                                    <input type="password" name="numero" class="form-control" id="inputNumero" placeholder="Contraseña" maxlength="4" onkeypress="return soloNumeros(event);">

                                    <script>
                                        function soloNumeros(e)
                                        {
                                            var teclaPulsada = window.event ? window.event.keyCode : e.which;
                                            var valor = document.getElementById("inputNumero").value
                                            if (teclaPulsada == 13)
                                            {
                                                return true;
                                            }
                                            return /\d/.test(String.fromCharCode(teclaPulsada));
                                        }
                                    </script>

                                    <br>
                                    <br>
                                    <div class="form-label-group">
                                        <center>
                                        <button type="submit" class="btn btn-danger"  >Ingresar</button>
                                         <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#modalRegister" >Registrarse</button>
                                        </center>
                                    </div>
                                </form>
                                <br>
                                <div class="form-label-group">
                                 <!--   <button type="submit" class="btn btn-danger" data-toggle="modal" data-target="#modalRegister" >Registrarse</button>-->
                                </div>
                            </div>
                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>


        <!--Modal de registro-->
        <form action="crearu">
            <div class="modal fade" id="modalRegister" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header text-white bg-danger mb-3">
                            <h5 class="modal-title" id="exampleModalLabel">Registro</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <label for="exampleInputEmail1">*Número de cédula</label>
                            <input type="number" class="form-control"  id="inputcc" name="cedula" maxlength="10" onkeypress="return soloNumeros(event);" required >

                            <label for="exampleInputEmail1">*Primer nombre</label>
                            <input type="" class="form-control" id="exampleInputEmail1" name="PNombre" aria-describedby="emailHelp" maxlength="20" placeholder="" required>

                            <label for="exampleInputEmail1">Segundo nombre</label>
                            <input type="text" class="form-control" id="exampleInputEmail1" name="SNombre" aria-describedby="emailHelp" maxlength="20" placeholder="" value=" ">

                            <label for="exampleInputEmail1">*Primer apellido</label>
                            <input type="text" class="form-control" id="exampleInputEmail1" name="PApellido" aria-describedby="emailHelp" maxlength="20" placeholder="" required>

                            <label for="exampleInputEmail1">Segundo apellido</label>
                            <input type="text" class="form-control" id="exampleInputEmail1" name="SApellido" aria-describedby="emailHelp" maxlength="20" placeholder="" value=" ">

                            <label for="exampleInputEmail1">*Número de celular</label>
                            <input type="number" class="form-control"  id="inputcc" name="Celular" maxlength="10" onkeypress="return soloNumeros(event);" required>

                            <label for="exampleInputPassword1">*Contraseña</label>
                            <input type="password"  class="form-control" id="inputNumero" name=pass  maxlength="4" onkeypress="return soloNumeros(event);" required>

                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-danger">Registrarse</button>
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>


        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>