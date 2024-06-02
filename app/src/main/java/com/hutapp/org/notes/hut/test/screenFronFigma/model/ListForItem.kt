package com.hutapp.org.notes.hut.test.screenFronFigma.model

import com.hutapp.org.notes.hut.test.R

object ListForItem {

    fun getList(): List<ModelIdem> {
        return listOf(
            ModelIdem(
                image = R.drawable.info,
                label = "Device info",
                text = "Show you all info about phone",
            ),
            ModelIdem(
                image = R.drawable.calibration,
                label = "Calibration of sensors",
                text = "Show you all info about",
                countMessage = 1
            ),
            ModelIdem(
                image = R.drawable.virus2,
                label = "AntiVirus",
                text = "Show you all info about",
            ),
            ModelIdem(
                image = R.drawable.folder,
                label = "Device Memory Information",
                text = "Show you all info about",
                countMessage = 3
            ),
            ModelIdem(
                image = R.drawable.file,
                label = "File manager",
                text = "Show you all info about",
            ),
            ModelIdem(
                image = R.drawable.batary,
                label = "Battery info",
                text = "Show you all info about",
            )
        )
    }
}