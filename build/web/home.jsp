<%-- 
    Document   : home
    Created on : 13/03/2019, 11:46:32 AM
    Author     : JoseJoaquinOrtizJaim
--%>


<%@page import="java.util.Locale"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="davivienda.*" %>
<% conexion2 conex = new conexion2();
    Statement estatuto = null;
    ResultSet rs = null;
%>

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
            <div class="row justify-content-center">
                <div class="card" style="width: 500px;">
                    <h5 class="card-header text-white bg-danger mb-3">Home</h5>
                    <div class="card-body">
                        <p class="card-text">

                            <%
                                estatuto = conex.getConexion().createStatement();
                                HttpSession objSession = request.getSession(false);
                                String cedula = (String) objSession.getAttribute("cedula");
                                String a = " ";
                                rs = estatuto.executeQuery("SELECT primernombre from  usuario where cedula_usuario = " + cedula);
                                while (rs.next()) {

                                    a = rs.getString(1);

                                }
                                out.println("<center> <h4> <b> Hola  " + a + "</b> </h4> </center>");


                            %>
                            <br>
                            <b>Tu saldo actual es:</b> 
                            <%                                estatuto = conex.getConexion().createStatement();

                                String b = " ";
                                String colombia =  " ";
                                rs = estatuto.executeQuery("SELECT c.monto from cuenta c, usuario u where u.id_usuario = c.id_usuario AND u.cedula_usuario = " + cedula);
                                while (rs.next()) {

                                    b = rs.getString(1);
                                    double monto = Double.parseDouble(b);
                                    colombia = NumberFormat.getCurrencyInstance(Locale.US).format(monto);
                                }
                                out.println("<center> <h2>  " + colombia + "</h2> </center>");


                            %>



                        </p>

                        <a class="btn btn-danger text-white" data-toggle="modal" data-target="#consignar">Consignar</a>
                        <a class="btn btn-danger text-white" data-toggle="modal" data-target="#retirar">Retirar</a>
                    </div>
                    <a  class="btn btn-danger text-white" data-toggle="modal" data-target="#cerrar">Cerrar sesión</a>
                </div>
            </div>
        </div>


        <!-- Modal Consignar monto -->
        <form action ="cmonto">
            <div class="modal fade" id="consignar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header text-white bg-danger mb-3">
                            <h5 class="modal-title" id="exampleModalLabel"> Consignar monto</h5>

                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <label for="exampleInputEmail1">Por favor indique el monto que desea consignar:</label>
                            <div class="input-group-prepend">
                                <span class="input-group-text">$</span>
                                <input type="text" class="form-control" name="numero" id="inputNumero" onkeypress="return soloNumeros(event); " maxlength="9">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-danger">Aceptar</button>
                            <button type="submit" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>



        <!-- Modal Retirar monto -->
        <form action ="sacar">
            <div class="modal fade" id="retirar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header text-white bg-danger mb-3">
                            <h5 class="modal-title" id="exampleModalLabel"> Retirar monto</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <label for="exampleInputEmail1">Por favor indique el monto que desea retirar:</label>
                            <div class="input-group-prepend">
                                <span class="input-group-text">$</span>
                                <input type="text" class="form-control" name="numero" id="inputNumero" onkeypress="return soloNumeros(event);" maxlength="9">


                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-danger">Aceptar</button>
                                <button type="submit" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>

        <!-- Modal Cerrar sesión -->

        <div class="modal fade" id="cerrar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-body">
                        <label for="exampleInputEmail1">¿Desea cerrar sesión?</label>

                    </div>
                    <div class="modal-footer">
                        <!--<form action="cerrar"> -->
                        <button type="submit" class="btn btn-danger" onclick  = "window.location.href = 'http://LAPTOP-L2CFMES6:8080/davivienda/index.jsp'" >Aceptar</button>
                      <!--<button type="submit" class="btn btn-danger" onclick  = "window.location.href = 'http://localhost:8080/fuentes/index.jsp'" >Aceptar</button>-->
                        <script Language="JavaScript">
                            if (history.forward(1)) {
                                history.replace(history.forward(1));
                            }
                        </script>
                        <!--</form>-->
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                    </div>
                </div>
            </div>
        </div>

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



        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>