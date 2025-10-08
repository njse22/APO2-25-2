package structures;

public class BST<T extends Comparable<T>> {

    private Node<T> root;

    public void add(T element){
        Node<T> node = new Node<>(element);
        // Caso Base: el árbol esta vacio
        if(root == null){
            root = node;
        }
        else {
            // El valor a agregar es menor que la raiz
            if(root.getLeft() == null && root.getValue().compareTo(element) > 0){
                root.setLeft(node);
            }
            else if(root.getLeft() != null && root.getValue().compareTo(element) > 0){
                // llamado al método privado
                add(root.getLeft(), node);
            }
            // El valor a agregar es mayor que la raíz
            else if(root.getRight() == null && root.getValue().compareTo(element) < 0){
                root.setRight(node);
            }
            else if(root.getRight() != null && root.getValue().compareTo(element) < 0){
                add(root.getRight(), node);
            }
            // si es igual
            else {
                // No se agrega
                // EXception (Por ejemplo)
            }
        }
    }

    private void add(Node<T> current, Node<T> node){
        // El valor del Node es menor que el valor del nodo
        // actual, se agrega a la izquierda
        if (current.getValue().compareTo(node.getValue()) > 0){
            // Caso Base: la izquierda es Null
            if(current.getLeft() == null){
                current.setLeft(node);
            }
            // Caso Recursivo: Se debe seguir buscando
            else {
               add(current.getLeft(), node);
            }
        }
        // El valor del Node es mayor que el valor del nodo actual (current)
        // se agrega a la derecha del current
        else if(current.getValue().compareTo(node.getValue()) < 0){
            if(current.getRight() == null){
                current.setRight(node);
            }
            else {
                add(current.getRight(), node);
            }
        }
        else {
            // No agregamos el nodo
        }

    }

    public boolean search(T element){
        boolean found = false;
        // Caso Base : is empty tree
        if(root == null){
            found = false;
        }
        // Caso recursivo
        else{
            search(root, element);
        }
        return found;
    }

    private boolean search(Node<T> current, T element){
        boolean found = false;
        if(current != null){
            if (current.getValue() == element){
                found = true;
            }
            else if(current.getValue().compareTo(element) > 0){
                found = search(current.getLeft(), element);
            }
            else if (current.getValue().compareTo(element) < 0){
                found = search(current.getRight(), element);
            }
        }

        return found;
    }

    public void delete(T element){

        if(root.getValue().compareTo(element) == 0){
            // Eliminar la raiz
            if(root.getRight() == null && root.getLeft() == null){
                root = null;
            } else if (root.getLeft() != null && root.getRight() == null) {
                root = root.getLeft();
            } else if (root.getLeft() == null && root.getRight() != null) {
                root = root.getRight();
            }else {
                Node<T> predecessor = getMax(root.getLeft());
                root.setValue(predecessor.getValue());
                delete(root, root.getLeft(), predecessor.getValue());
            }
        }
        else {
            delete(null, root, element );
        }

    }

    private void delete(Node<T> parent, Node<T> current, T element){
        // Buscar el nodo
        if(current != null){
            // Caso Base -> Encontramos el nodo
            if (current.getValue() == element){
                // ES nodo hoja
                if(current.getRight() == null && current.getLeft() == null){
                    // Hijo izq
                    if(parent.getLeft() == current){
                        parent.setLeft(null);
                    }
                    // Hijo der
                    else {
                        parent.setRight(null);
                    }
                }
                // CASO BASE
                // Unico hijo izq
                else if (current.getLeft() != null && current.getRight() == null){
                    // Hijo izq
                    if(parent.getLeft() == current){
                       parent.setLeft(current.getLeft());
                       current.setLeft(null);
                    }
                    // Hijo der
                    else {
                        parent.setRight(current.getLeft());
                        current.setLeft(null);
                    }

                }
                // Unico hijo der
                else if (current.getLeft() == null && current.getRight() != null){
                    // Hijo izq
                    if(parent.getLeft() == current){
                        parent.setLeft(current.getRight());
                        current.setRight(null);
                    }
                    // Hijo der
                    else {
                        parent.setRight(current.getRight());
                        current.setRight(null);
                    }
                }
                // Ambos hijos
                else if (current.getLeft() != null && current.getRight() != null){
                    Node<T> predecessor = getMax(current.getLeft());
                    current.setValue(predecessor.getValue());
                    delete(current, current.getLeft(), predecessor.getValue());
                }

            }
            // El elemento a eliminar es menor que el nodo actual
            else if(current.getValue().compareTo(element) > 0){
                delete(current, current.getLeft(), element);

            }
            // El elemento a eliminar es mayor que el nodo actual
            else if (current.getValue().compareTo(element) < 0){
                delete(current, current.getRight(), element);
            }
        }
    }

    public T getMax(){
        return getMax(root).getValue();
    }

    private Node<T> getMax(Node<T> current){
        Node<T> max = null;
        if(current != null){
            if(current.getRight() != null){
                max = getMax(current.getRight());
            }
            else {
                max = current;
            }
        }
        return max;
    }

    public String inOrder(){
        String msj = "";

        if (root != null){
            msj = inOrder(root);
        }
        else {
            msj = "Is empty tree";
        }
        return msj;
    }

    private String inOrder(Node<T> curent){
        // Caso recursio
        if(curent != null){
            // Recorrido por izquerda           |   Valor actual          |     Recorrido por derecha
            return inOrder(curent.getLeft()) + " " + curent.getValue() + " " + inOrder(curent.getRight());
        }
        // Caso base
        else {
            return "";
        }
    }


}
