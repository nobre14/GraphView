package com.nobre.graficos;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private BarChart barChart;
    private ArrayList<BarEntry> barEntries;
    private ArrayList<String> meses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barChart = findViewById(R.id.barChart);

        barEntries = new ArrayList<>();
        meses = new ArrayList<>();
        List<DadosMesNumero> listaDados = preencheListaMeses();
        for (int x = 0; x < listaDados.size(); x++) {
            String mes = listaDados.get(x).getMes();
            float numero = (float)listaDados.get(x).getNumero();

            barEntries.add(new BarEntry(x, numero));
            meses.add(mes);
        }


        BarDataSet barDataSet = new BarDataSet(barEntries, "Lucro Mensal em R$");
        barDataSet.setColors(Color.GREEN);
        barDataSet.setValueTextSize(10f);

        Description description = new Description();
        description.setText("");

        barChart.setDescription(description);

        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);

        // formata o eixo x do grafico
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(meses));
        xAxis.setTextSize(12f);

        // define a posicao dos nomes(Meses)
        xAxis.setPosition(XAxis.XAxisPosition.TOP);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        xAxis.setGranularity(1f);
        xAxis.setLabelCount(meses.size());
        xAxis.setLabelRotationAngle(270);


        barChart.animateY(2000);
        barChart.invalidate();
    }

    private List<DadosMesNumero> preencheListaMeses() {
        List<DadosMesNumero> listaObj = new ArrayList<>();
        listaObj.add(new DadosMesNumero("jan", 1000.12));
        listaObj.add(new DadosMesNumero("fev", 1000));
        listaObj.add(new DadosMesNumero("mar", 1000.5));
        listaObj.add(new DadosMesNumero("abr", 1000));
        listaObj.add(new DadosMesNumero("maio", 1000.69));
        listaObj.add(new DadosMesNumero("jun", 2000));
        listaObj.add(new DadosMesNumero("jul", 1000));
        listaObj.add(new DadosMesNumero("ago", 1000));
        listaObj.add(new DadosMesNumero("set", 1000));
        listaObj.add(new DadosMesNumero("out", 1000));
        listaObj.add(new DadosMesNumero("nov", 1000));
        listaObj.add(new DadosMesNumero("dez", 1000));
        return listaObj;
    }
}
