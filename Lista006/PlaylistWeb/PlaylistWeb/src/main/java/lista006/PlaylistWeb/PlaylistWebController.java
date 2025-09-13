package lista006.PlaylistWeb;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/playlists")
public class PlaylistWebController {

    private List<Playlist> playlists = new ArrayList<>();
    private int playlistIdCounter = 1;

    @PostMapping
    public int criarPlaylist(@RequestBody Playlist playlist) {
        playlist.setId(playlistIdCounter++);
        playlists.add(playlist);
        return playlist.getId();
    }

    @PostMapping("/{id}/musicas")
    public String adicionarMusica(@PathVariable int id, @RequestBody Musica musica) {
        for (Playlist p : playlists) {
            if (p.getId() == id) {
                p.getMusicas().add(musica);
                return "Música adicionada com sucesso!";
            }
        }
        return "Playlist não encontrada!";
    }

    @GetMapping
    public List<Playlist> listarPlaylists() {
        return playlists;
    }

    @GetMapping("/{id}/musicas")
    public List<Musica> listarMusicas(@PathVariable int id) {
        for (Playlist p : playlists) {
            if (p.getId() == id) {
                return p.getMusicas();
            }
        }
        return new ArrayList<>();
    }
}
