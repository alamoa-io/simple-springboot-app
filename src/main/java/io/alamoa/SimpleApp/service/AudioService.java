package io.alamoa.SimpleApp.service;

import io.alamoa.SimpleApp.logic.AudioLogic;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class AudioService {

    private final AudioLogic audioLogic;

    public AudioService(AudioLogic audioLogic) {
        this.audioLogic = audioLogic;
    }

    public String convertAudioToText(MultipartFile file) {

        Path copiedFile = null;
        try {
            copiedFile = createTempFile(file);

            if (!hasAllowedExtension(copiedFile)) {
                return "変換可能ファイルは、flac, mp3, mp4, mpeg, mpga, m4a, ogg, wav, webmのみです";
            }

            return audioLogic.getConvertedAudioText(copiedFile);

        } catch (IOException e) {
            return "システムエラーが発生しました、時間を置いて再度アクセスしてください";
        } finally {
            try {
                if (copiedFile != null) {
                    Files.deleteIfExists(copiedFile);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Path createTempFile(MultipartFile file) throws IOException {
        Path tempFile = Files.createTempFile("upload_", "_" + file.getResource().getFilename());
        file.transferTo(tempFile);
        return tempFile;
    }

    private boolean hasAllowedExtension(Path file) {
        String fileName = file.getFileName().toString();
        String ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
        List<String> allowedExtension = List.of("flac", "mp3", "mp4", "mpeg", "mpga", "m4a", "ogg", "wav", "webm");
        return allowedExtension.contains(ext);
    }
}