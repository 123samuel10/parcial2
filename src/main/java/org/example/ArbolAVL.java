package org.example;

public class ArbolAVL {
    Nodo raiz;  // Nodo raíz del árbol

    // Método para obtener la altura de un nodo
    public int obtenerAltura(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return Math.max(obtenerAltura(nodo.izquierdo), obtenerAltura(nodo.derecho)) + 1;
    }

    // Método para obtener el factor de balance (balance factor)
    public int obtenerFactorBalance(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return obtenerAltura(nodo.izquierdo) - obtenerAltura(nodo.derecho);
    }

    // Rotación simple a la derecha
    public Nodo rotarDerecha(Nodo y) {
        Nodo x = y.izquierdo;
        Nodo T2 = x.derecho;

        // Realizar la rotación
        x.derecho = y;
        y.izquierdo = T2;

        return x;  // Nueva raíz
    }

    // Rotación simple a la izquierda
    public Nodo rotarIzquierda(Nodo x) {
        Nodo y = x.derecho;
        Nodo T2 = y.izquierdo;

        // Realizar la rotación
        y.izquierdo = x;
        x.derecho = T2;

        return y;  // Nueva raíz
    }

    // Método para balancear el árbol
    public Nodo balancear(Nodo nodo, int valor) {
        int balance = obtenerFactorBalance(nodo);

        // Caso de rotación a la derecha
        if (balance > 1 && valor < nodo.izquierdo.valor) {
            return rotarDerecha(nodo);
        }

        // Caso de rotación a la izquierda
        if (balance < -1 && valor > nodo.derecho.valor) {
            return rotarIzquierda(nodo);
        }

        // Caso de rotación doble izquierda-derecha
        if (balance > 1 && valor > nodo.izquierdo.valor) {
            nodo.izquierdo = rotarIzquierda(nodo.izquierdo);
            return rotarDerecha(nodo);
        }

        // Caso de rotación doble derecha-izquierda
        if (balance < -1 && valor < nodo.derecho.valor) {
            nodo.derecho = rotarDerecha(nodo.derecho);
            return rotarIzquierda(nodo);
        }

        return nodo;  // Si ya está balanceado
    }

    // Método para insertar un valor en el árbol
    public Nodo insertar(Nodo nodo, int valor) {
        // Realizamos la inserción normal de un árbol binario de búsqueda
        if (nodo == null) {
            return new Nodo(valor);
        }

        if (valor < nodo.valor) {
            nodo.izquierdo = insertar(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = insertar(nodo.derecho, valor);
        } else {
            return nodo;  // No permitir valores duplicados
        }

        // Balancear el nodo después de la inserción
        return balancear(nodo, valor);
    }

    // Método para verificar si el árbol es AVL
    public boolean esAVL(Nodo nodo) {
        if (nodo == null) {
            return true;
        }

        int balance = obtenerFactorBalance(nodo);

        // El árbol no es AVL si el factor de balance está fuera del rango [-1, 1]
        if (balance > 1 || balance < -1) {
            return false;
        }

        // Verificar recursivamente los subárboles izquierdo y derecho
        return esAVL(nodo.izquierdo) && esAVL(nodo.derecho);
    }

    // Método para iniciar la inserción
    public void insertar(int valor) {
        raiz = insertar(raiz, valor);
    }

    // Método para iniciar la verificación si el árbol es AVL
    public boolean verificarAVL() {
        return esAVL(raiz);
    }
}
