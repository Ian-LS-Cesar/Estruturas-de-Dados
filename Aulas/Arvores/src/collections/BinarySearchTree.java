package collections;
import exceptions.EmptyTreeException;
public class BinarySearchTree<E> extends AbstractTree<E> {

    @Override
    public void clear() {
        root = null;
        size = 0;
        
    }

    @Override
    public boolean contains(E value) {
        // TODO Auto-generated method stub
        return false;
    }

    private E removeMinNode(Node parent){
        Node minNode = parent.right;
        while(minNode.left != null){
            parent = minNode;
            minNode = minNode.left;
        }

        if(minNode.right != null){
            if(parent.left == minNode){
                parent.left = minNode.right;
            }else{
                parent.right = minNode.right;
            }
        }else{
            if(parent.left == minNode){
                parent.left = null;
            }else{
                parent.right = null;
            }
        }
        return minNode.value;

    }

    @Override
    public E delete(E value) {
        if (isEmpty()){
            throw new EmptyTreeException("This Tree is Empty!");
        }

        Node target = root, parent = null;

        //Buscar o nó
        while(target != null && compare(value, target.value) != 0){
            parent = target;

            if(compare(value, target.value) > 0){
                target = target.right;
            }else{
                target = target.left;
            }

            if(target == null){
                return null;
            }

            if(target.left == null && target.right == null){
                //Folha!!
                if(target == root){
                    root = null;
                }else{
                    if (parent.left == target){
                        parent.left = null;
                    }else{
                        parent.right = null;
                    }
                }

            }else if (target.left != null && target.right != null){
                target.value = removeMinNode(target);
            }else{
                Node child = target.left!=null?target.left:target.right;

                if(target == root){
                    root = child;
                }else{
                    if(parent.left == target){
                        parent.left = child;
                    }else{
                        parent.right = child;
                    }
                }
            }
            size--;
        }
        return target.value;
    }

    @Override
    public E get(E value) {
        // TODO Auto-generated method stub
        return null;
    }

    

    @Override
    public void insert(E value) {
        Node newNode = new Node(value);
        if(isEmpty()){
            root = newNode;
        }else{
            Node auxNode = root;
            while(true){
                if(compare(newNode, auxNode)<0){
                    if(auxNode.left == null){
                        auxNode.left = newNode;
                        break;
                    }
                    auxNode = auxNode.left;
                }else if(compare(newNode, auxNode)>0){
                    if(auxNode.right == null){
                        auxNode.right = newNode;
                        break;
                    }
                    auxNode = auxNode.right;
                }else{
                    return;
                }
            }
        }
        size++;
    }

    @Override
    public void treeTraversal() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String toString() {
        return "BinarySearchTree []";
    }

    

    

}
