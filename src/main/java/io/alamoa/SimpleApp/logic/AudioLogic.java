package io.alamoa.SimpleApp.logic;

import com.openai.client.OpenAIClient;
import com.openai.models.audio.AudioModel;
import com.openai.models.audio.transcriptions.Transcription;
import com.openai.models.audio.transcriptions.TranscriptionCreateParams;
import org.springframework.stereotype.Component;

import java.nio.file.Path;

@Component
public class AudioLogic {

    private final OpenAIClient client;

    public AudioLogic(OpenAIClient client) {
        this.client = client;
    }

    public String getConvertedAudioText(Path path) {
        TranscriptionCreateParams createParams = TranscriptionCreateParams.builder()
                .file(path)
                .model(AudioModel.WHISPER_1)
                .build();

        Transcription transcription =
                client.audio().transcriptions().create(createParams).asTranscription();
        return transcription.text();
    }
}
