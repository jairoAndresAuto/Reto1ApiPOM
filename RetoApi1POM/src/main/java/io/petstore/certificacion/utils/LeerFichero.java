package io.petstore.certificacion.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class LeerFichero {

    private XSSFWorkbook workbook;
    private FileInputStream campo;

    public LeerFichero() {
    }

    public LeerFichero(XSSFWorkbook workbook, FileInputStream campo) {
        this.workbook = workbook;
        this.campo = campo;
    }

    public String leerDatoExcel(String hoja, String ruta, int valorColumna, int valorFila) throws IOException {
        String value = null;
        campo = new FileInputStream(new File(ruta));
        workbook = new XSSFWorkbook(campo);
        Sheet sheet = workbook.getSheet(hoja);
        Row row = sheet.getRow(valorFila);
        Cell cell = row.getCell(valorColumna);
        value = cell.getStringCellValue();
        return value;
    }

    public List<String> extraerDatosCrear()throws Exception{
        String hoja="Hoja1";
        String nombreArchivo ="DataUsuario.xlsx";
        List<String> listaDatos=new LinkedList<>();

        for (int i=0;i<8;i++){
            switch (i) {
                case 0:
                    listaDatos.add(leerDatoExcel(hoja,nombreArchivo,i,1));
                    break;
                case 1:
                    listaDatos.add(leerDatoExcel(hoja,nombreArchivo,i,1));
                    break;
                case 2:
                    listaDatos.add(leerDatoExcel(hoja,nombreArchivo,i,1));
                    break;
                case 3:
                    listaDatos.add(leerDatoExcel(hoja,nombreArchivo,i,1));
                    break;
                case 4:
                    listaDatos.add(leerDatoExcel(hoja,nombreArchivo,i,1));
                    break;
                case 5:
                    listaDatos.add(leerDatoExcel(hoja,nombreArchivo,i,1));
                    break;
                case 6:
                    listaDatos.add(leerDatoExcel(hoja,nombreArchivo,i,1));
                    break;
                case 7:
                    listaDatos.add(leerDatoExcel(hoja,nombreArchivo,i,1));
                    break;
            }
        }
        return listaDatos;
    }

    public List<String> extraerDatosActualizar()throws Exception{
        String hoja="Hoja1";
        String nombreArchivo ="DataUsuario.xlsx";
        List<String> listaDatos=new LinkedList<>();

        for (int i=0;i<8;i++){
            switch (i) {
                case 0:
                    listaDatos.add(leerDatoExcel(hoja,nombreArchivo,i,2));
                    break;
                case 1:
                    listaDatos.add(leerDatoExcel(hoja,nombreArchivo,i,2));
                    break;
                case 2:
                    listaDatos.add(leerDatoExcel(hoja,nombreArchivo,i,2));
                    break;
                case 3:
                    listaDatos.add(leerDatoExcel(hoja,nombreArchivo,i,2));
                    break;
                case 4:
                    listaDatos.add(leerDatoExcel(hoja,nombreArchivo,i,2));
                    break;
                case 5:
                    listaDatos.add(leerDatoExcel(hoja,nombreArchivo,i,2));
                    break;
                case 6:
                    listaDatos.add(leerDatoExcel(hoja,nombreArchivo,i,2));
                    break;
                case 7:
                    listaDatos.add(leerDatoExcel(hoja,nombreArchivo,i,2));
                    break;
            }
        }
        return listaDatos;
    }

}
