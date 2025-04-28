package io.alamoa.SimpleApp.controller;

import io.alamoa.SimpleApp.service.AudioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AudioController {

    private final AudioService audioService;

    public AudioController(AudioService audioService) {
        this.audioService = audioService;
    }

    @GetMapping("/audio")
    public String showAudioPage(Model model) {
        return "audioView";
    }

    @PostMapping("/audio")
    public String convertAudio(@RequestParam("file") MultipartFile file, Model model) {
        String responseText = audioService.convertAudioToText(file);
        model.addAttribute("responseText", responseText);
        return "audioView";

    }
}
