package br.com.alura.screenmatch.model;

import br.com.alura.screenmatch.service.ConsultaChatGPT;
import br.com.alura.screenmatch.service.traducao.ConsultaMyMemory;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

@Entity//notação para identificar como uma entidade no banco de dados
@Table(name= "series")// notação para indicar que no BD o nome será series
public class Serie {

    @Id//anotação para identificar como id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//notação que coloca como um ID auto incremental
    private Long id;

//  @Column(name= "nomeDaSerie") - notação caso fosse colocar outro nome para título no BD
    @Column(unique = true)// Aqui indica que o titulo sera unico no BD, não poderá existir 2 series com o mesmo titulo
    private String titulo;
    private Integer totalTemporadas;
    private Double avaliacao;

    @Enumerated(EnumType.STRING)// indica que Categoria é do tipo Enum
    private Categoria genero;
    private String atores;
    private String poster;
    private String sinopse;


    // @Transient//notação para não executar por enquanto esta parte do código - não representar ele no BD
    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, fetch =FetchType.EAGER ) // Um para muitos(uma série para vários episódios)
    private List<Episodio> episodios = new ArrayList();


    public Serie(){}

    public Serie(DadosSerie dadosSerie) {
        this.titulo = dadosSerie.titulo();
        this.totalTemporadas = dadosSerie.totalTemporadas();
        this.avaliacao = OptionalDouble.of(Double.valueOf(dadosSerie.avaliacao())).orElse(0);
        this.genero = Categoria.fromString(dadosSerie.genero().split(",")[0].trim());
        this.atores = dadosSerie.atores();
        this.poster = dadosSerie.poster();
        //Com a API MyMemory
        this.sinopse = ConsultaMyMemory.obterTraducao(dadosSerie.sinopse()).trim();

        //Sem a tradução
        //this.sinopse = dadosSerie.sinopse();

        // Caso fosse usar a tradução do chatgpt
        //this.sinopse = ConsultaChatGPT.obterTraducao(dadosSerie.sinopse()).trim();

        // Aqui substitui a chamada à API por uma mensagem temporária, Pois a chave não funciona
        //this.sinopse = "Tradução desativada temporariamente devido a limites da API.";

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<Episodio> episodios) {
        episodios.forEach(e -> e.setSerie(this));
        this.episodios = episodios;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTotalTemporadas() {
        return totalTemporadas;
    }

    public void setTotalTemporadas(Integer totalTemporadas) {
        this.totalTemporadas = totalTemporadas;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Categoria getGenero() {
        return genero;
    }

    public void setGenero(Categoria genero) {
        this.genero = genero;
    }

    public String getAtores() {
        return atores;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    @Override
    public String toString() {
        return  " genero=" + genero +
                ", titulo='" + titulo + '\'' +
                ", totalTemporadas=" + totalTemporadas +
                ", avaliacao=" + avaliacao +
                ", atores='" + atores + '\'' +
                ", poster='" + poster + '\'' +
                ", sinopse='" + sinopse + '\'' +
                ", episodios='" + episodios + '\'';
    }

}
