package net.almic.basiclinechart;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

public class ChartActivity extends AppCompatActivity {

    private LineChart lineChart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        lineChart = findViewById(R.id.lineChart);

        // How to make changes to the data

        // Set base data
        LineData data = getData();
        lineChart.setData(data);

        // Get the data set
        LineDataSet set = (LineDataSet) lineChart.getLineData().getDataSetByIndex(0);

        // Add new data
        set.addEntry(new Entry(7f, 5.8f));

        // Refresh the chart
        lineChart.getData().notifyDataChanged();
        lineChart.notifyDataSetChanged();
        lineChart.invalidate();
    }

    private LineDataSet buildDataSet() {
        ArrayList<Entry> values = new ArrayList<>();

        float[][] entries = {{1f, 2f}, {2f, 3.5f}, {3f, 4f}, {4f, 3f}, {5f, 4.7f}, {6f, 8f}};

        for (float[] entry : entries) {
            values.add(new Entry(entry[0], entry[1]));
        }

        return new LineDataSet(values, "Profits");
    }

    private LineData getData() {
        LineDataSet dataSet = buildDataSet();

        return new LineData(dataSet);
    }

}
