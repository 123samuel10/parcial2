package org.example;

public class Main {
    public static void main(String[] args) {
        ArbolAVL arbol = new ArbolAVL();

        // Insertar valores
        arbol.insertar(10);
        arbol.insertar(-30);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);
        arbol.insertar(-90);

        // Verificar si el árbol es AVL
        if (arbol.verificarAVL()) {
            System.out.println("El árbol es un AVL.");
        } else {
            System.out.println("El árbol no es un AVL.");
        }

    }
}