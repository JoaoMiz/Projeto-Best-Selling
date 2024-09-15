import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Metodos {
    List<Book> livros = new DatasetReader().readDataset("src/data.csv");
    public int NumeroLivrosPorAutor(String autor) {

        Set<String> unicos = new HashSet<>();

        for (Book x : livros) {
            if (x.getAuthor().equals(autor)) {
                unicos.add(x.getTitle());
            }
        }
        System.out.println("Número total de livros únicos de " + autor + ": " + unicos.size());
        return 0;
    }
    public int TodosAutores(){
        ArrayList<String> autores = new ArrayList<>();
        for (Book x : livros) {
            if (!autores.contains(x.getAuthor())) {
                autores.add(x.getAuthor());
            }
        }
        for (String autor : autores) {
            System.out.println(autor);
        }
        return 0;

    }
    public int TodosTitulosPorAutor(String autor){
        ArrayList<String> livrosPorAutor = new ArrayList<>();

        for (Book x : livros) {
            if(x.getAuthor().equals(autor)) {
                if(!livrosPorAutor.contains(x.getTitle())) {
                    livrosPorAutor.add(x.getTitle());
                }
            }
        }
        for (String livro : livrosPorAutor) {
            System.out.println(livro);
        }
        return 0;
    }
    public int ClassificarPorAvaliacao(String avaliacao){

        ArrayList<Book> livrosAutoresPorAvaliacao = new ArrayList<>();
        ArrayList<String> titulosAutores = new ArrayList<>();

        for (Book x : livros) {
            if (x.getUserRating().equals(avaliacao)) {
                    if (!titulosAutores.contains(x.getTitle())) {
                        titulosAutores.add(x.getTitle());
                        livrosAutoresPorAvaliacao.add(x);
                    }
            }
        }
        for (Book livro : livrosAutoresPorAvaliacao) {
            System.out.println(livro.getTitle() + " de " + livro.getAuthor());
        }
        return 0;
    }
    public int NomePrecoPorAutor(String autor){
        ArrayList<Book> nomePrecoAutor = new ArrayList<>();
        ArrayList<String> titulosUsados = new ArrayList<>();
        //itera sobre livros
        for (Book x : livros) {
            //se o titulo for igual o autor
            if (x.getAuthor().equals(autor)) {
                //se o titulo nao esta em titulosUsados, adiciona livro e titulo logo filtra por tituol
                if (!titulosUsados.contains(x.getTitle())) {
                    titulosUsados.add(x.getTitle());
                    nomePrecoAutor.add(x);
                }
            }
        }
        //pega o livro da lista que foi filtrada por nome
        for (Book livro : nomePrecoAutor) {
            System.out.println(livro.getTitle() + " - " + livro.getPrice());
        }

        return 0;
    }

}