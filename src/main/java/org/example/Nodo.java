package org.example;

public class Nodo {
    int valor;  // Valor que guarda el nodo
    Nodo izquierdo, derecho;  // Punteros a los nodos izquierdo y derecho

    public Nodo(int valor) {
        this.valor = valor;
        izquierdo = derecho = null;  // Inicialmente no tiene hijos
    }
}
