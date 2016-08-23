
public class ListArrayOfInteger {

    private static final int INITIAL_SIZE = 10;
    private Integer[] data;
    private int count;

    /**
     * Construtor da lista
     */
    public ListArrayOfInteger() {
        this(INITIAL_SIZE);
    }

    /**
     * Construtor da lista
     *
     * @param tam tamanho inicial a ser alocado para data[]
     */
    public ListArrayOfInteger(int tam) {
        if (tam <= 0) {
            tam = INITIAL_SIZE;
        }
        data = new Integer[tam];
        count = 0;
    }

    /**
     * Esvazia a lista
     */
    public void clear() {
        data = new Integer[INITIAL_SIZE];
        count = 0;
    }

    /**
     * Retorna true se a lista não contêm elementos
     *
     * @return true se a lista não contêm elementos
     */
    public boolean isEmpty() {
        return (count == 0);
    }

    /**
     * Retorna o número de elementos da lista
     *
     * @return o número de elementos da lista
     */
    public int size() {
        return count;
    }

    /**
     * Adiciona um elemento ao final da lista
     *
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Integer element) {
        if (count == data.length) {
            setCapacity(data.length * 2);
        }
        data[count] = element;
        count++;
    }

    /**
     * Insere um elemento em uma determinada posição da lista
     *
     * @param index a posição da lista onde o elemento será inserido
     * @param element elemento a ser inserido
     * @throws IndexOutOfBoundsException se (index < 0 || index > size())
     */
    public void add(int index, Integer element) {

        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        if (count == data.length) {
            setCapacity(data.length * 2);
        }

        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        count++;
    }

    /**
     * Remove o elemento de uma determinada posição da lista
     *
     * @param index a posição da lista
     * @return o elemento que foi removido da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public int removeByIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        int aux = data[index];

        for (int i = index; i < count - 1; i++) {
            data[i] = data[i + 1];
        }

        data[count - 1] = 0;
        count--;

        return aux;
    }

    /**
     * Remove a primeira ocorrência do elemento na lista, se estiver presente
     *
     * @param element o elemento a ser removido
     * @return true se a lista contém o elemento especificado
     */
    public boolean remove(Integer element) {

        for (int i = 0; i < count; i++) {

            if (element.equals(data[i])) {
                for (int j = i; j < count - 1; j++) {
                    data[j] = data[j + 1];
                }
                data[count - 1] = 0;
                count--;
                return true;
            }
        }
        return false;
    }

    /**
     * Retorna o elemento de uma determinada posição da lista
     *
     * @param index a posição da lista
     * @return o elemento da posição especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public int get(int index) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        return data[index];
    }

    /**
     * Substitui o elemento armanzenado em uma determinada posição da lista pelo
     * elemento indicado
     *
     * @param index a posição da lista
     * @param element o elemento a ser armazenado na lista
     * @return o elemento armazenado anteriormente na posição da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public int set(int index, Integer element) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        int item = data[index];
        data[index] = element;
        return item;
    }

    /**
     * Retorna true se a lista contém o elemento especificado
     *
     * @param element o elemento a ser testado
     * @return true se a lista contém o elemento especificado
     */
    public boolean contains(Integer element) {
        for (int p = 0; p < count; p++) {
            if (data[p].equals(element)) {
                return true;
            }
        }
        // Neste ponto, não achou: retorna falso
        return false;
    }

    /**
     * Retorna o índice da primeira ocorrência do elemento na lista, ou -1 se a
     * lista não contém o elemento
     *
     * @param element o elemento a ser buscado
     * @return o índice da primeira ocorrência do elemento na lista, ou -1 se a
     * lista não contém o elemento
     */
    public int indexOf(Integer element) {
        // Procura elemento no array, se achar retorna
        for (int p = 0; p < count; p++) {
            if (data[p].equals(element)) {
                return p;
            }
        }
        // Neste ponto, não achou: retorna -1
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("{");
        for (int i = 0; i < count; i++) {
            s.append(data[i]);
            if (i != (count - 1)) {
                s.append(",");
            }
        }
        s.append("}");
        return s.toString();
    }

    private void setCapacity(int newCapacity) {
        if (newCapacity != data.length) {
            int min = 0;
            Integer[] newData = new Integer[newCapacity];
            if (data.length < newCapacity) {
                min = data.length;
            } else {
                min = newCapacity;
            }
            for (int i = 0; i < min; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }


    /**
     * Remove desta lista todas as ocorrencias dos elementos que estao na
     * colecao passada por parametro. Nao podem ser chamados outros metodos da
     * classe para fazer a remocao, isto e, o atributo data deve ser manipulado
     * diretamente. Exemplo do resultado esperado: 
     * ListArrayOfInteger A contem: [1,2,3,2,4,3,5] 
     * ListArrayOfInteger B contem: [2,3] 
     * Conteudo de A apos chamada A.removeAll(B): [1,4,5]
     * @param collection colecao a ser verificada
     * @return true se esta lista for alterada, e false caso contrario.
     * Caracterizacao O do tempo de execucao do metodo implementado:
     * _________________
     */
    public boolean removeAll(ListArrayOfInteger collection) {
        
        return true;
    }

    /**
     * Verifica se esta lista contém todos os elementos da coleção passada por
     * parâmetro. Nao podem ser chamados outros metodos da classe, isto e, o
     * atributo data deve ser manipulado diretamente. Exemplo do resultado
     * esperado: 
     * ListArrayOfInteger A contem: [1,2,3,2,4,3,5] 
     * ListArrayOfInteger B contem: [2,3] 
     * Resultado de A.containsAll(B): true
     * @param collection colecao a ser verificada
     * @return true se esta lista contem todos os elementos da colecao, 
     * e false caso contrario.
     * Caracterizacao O do tempo de execucao do metodo implementado:
     * _________________ 
     */
    public boolean containsAll(ListArrayOfInteger collection) {

        return true;
    }
    
    /***
     * Tempo de execução do método é O(n3) 
     * @param lista2
     * @return
     */

	public ListArrayOfInteger union(ListArrayOfInteger lista2) {
		ListArrayOfInteger unionOfElements = new ListArrayOfInteger(10);
		
		for (int i = 0; i < this.count; i++) {
			unionOfElements.add(data[i]);
		}
		
		for (int i = 0; i < lista2.count; i++) {
			int element = lista2.get(i);
			if(!unionOfElements.contains(element)){
				unionOfElements.add(element);
			}
		}
		
		return unionOfElements;
	}
	
	/***
	 * Tempo de execução do método é O(n2) 
	 * @param lista2
	 * @return
	 */
	public ListArrayOfInteger intersect(ListArrayOfInteger lista2) {
		ListArrayOfInteger intersectOfElements = new ListArrayOfInteger(10);
		
		for (int i = 0; i < lista2.count; i++) {
			int element = lista2.get(i);
			if(this.contains(element)){
				intersectOfElements.add(element);
			}
		}
		
		return intersectOfElements;
	}
	
	
}
