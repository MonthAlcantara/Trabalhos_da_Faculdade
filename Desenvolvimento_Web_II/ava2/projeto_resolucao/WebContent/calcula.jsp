<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resolucao Ava2 - Montival Junior</title>
    </head>
    <body>
        <form  method="get" action="Calculo">
            <table>
                <tr>
                    <td>Valor 1: </td>
                    <td>
                        <input type="text" size="10" name="valor1" value=${valor1}>
                        <span style="color:red">${erroValor1}</span>
                    </td>
                </tr>
                <tr>
                    <td>Valor 2: </td>
                    <td>
                        <input type="text" size="10" name="valor2" value=${valor2}>
                        <span style="color:red">${erroValor2}</span>
                        <span style="color:red">${erroDiv}</span>
                    </td>
                </tr>   
                <tr>
                    <td>Op:</td>
                    <td>
                        <select name="op">
                            <option value = "+"> + </option>
                            <option value = "-"> - </option>
                            <option value = "*"> * </option>
                            <option value = "/"> / </option>
                        </select>

                    </td>
                <tr>
                    <td><span>${tmp}</span></td>
                    <td><span style="color:red">${expressao}</span></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Calcula"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
