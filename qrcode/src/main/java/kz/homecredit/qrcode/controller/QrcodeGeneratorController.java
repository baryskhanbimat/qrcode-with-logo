package kz.homecredit.qrcode.controller;

import com.google.zxing.WriterException;
import kz.homecredit.qrcode.model.QrCode;
import kz.homecredit.qrcode.service.QrcodeGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/v1")
public class QrcodeGeneratorController {
    @Autowired
    private QrcodeGeneratorService qrcodeGeneratorService;

    @RequestMapping(method = RequestMethod.POST, value = "/generate", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public ResponseEntity<byte[]> generateQRcode(@RequestBody QrCode qrCode) throws IOException, WriterException {
        byte[] response = qrcodeGeneratorService.generate(qrCode.getText(), qrCode.getWidth(), qrCode.getHeight());
        return ResponseEntity.ok(response);
    }
}
