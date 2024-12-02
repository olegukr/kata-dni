# kata-dni

Modula una aplicación de consola que calcule la letra del DNI (Documento nacional de identidad).

El algoritmo para calcular la letra del DNI es el siguiente :
El número debe ser entre 0 y 99999999
Tomamos el número completo de hasta 8 cifras de nuestro DNI, lo dividimos entre 23 y nos quedamos con el resto de dicha división (módulo 23)
Según el resultado, de 0 a 22, le corresponderá una letra de las siguientes:  (T, R, W, A, G, M, Y, F, P, D, X, B, N, J, Z, S, Q, V, H, L, C, K, E)
Si el dato introducido no es un número deberá indicarse con un mensaje que "el dato introducido es incorrecto" y volver a preguntar.
Deberá de repetirse el proceso hasta que el usuario introduzca un número válido.
Requisitos:
Se deberá realizar tests unitarios (coverage mínimo 70%)
Entregables:
Repositorio de GitHub (enlace)
Captura de pantalla de la sección "Testing" de visual studio code donde se aprecia el coverage de los tests

----

Modulates a console application that calculates the letter of the DNI (National Identity Document).

The algorithm to calculate the letter of the DNI is the following:
The number must be between 0 and 99999999
We take the complete number of up to 8 digits of our ID, divide it by 23 and keep the remainder of said division (modulo 23)
Depending on the result, from 0 to 22, you will receive one of the following letters: (T, R, W, A, G, M, Y, F, P, D, X, B, N, J, Z, S, Q, V, H, L, C, K, E)
If the data entered is not a number, a message should be displayed stating that "the data entered is incorrect" and the user should be asked again.
The process must be repeated until the user enters a valid number.
Requirements:
Unit tests must be performed (minimum coverage 70%)
Deliverables:
GitHub repository (link)
Screenshot of the "Testing" section of Visual Studio Code where the coverage of the tests can be seen