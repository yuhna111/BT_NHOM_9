/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

/**
 *
 * @author yuhna
 */
import Model.ViTriDo;
import Repository.ViTriDoRepository;
import Service.ViTriDoService;

import java.util.List;
import java.util.stream.Collectors;

public class ViTriDoServiceImpl implements ViTriDoService {
    private final ViTriDoRepository repo = new ViTriDoRepository();

    @Override
    public List<ViTriDo> getAllViTriTrong() {
        return repo.findAll().stream()
                   .filter(vt -> "Trống".equals(vt.getTrangThai()))
                   .collect(Collectors.toList());
    }
}
