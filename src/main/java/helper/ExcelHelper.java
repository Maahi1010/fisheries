package helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fisheries.VO.FisherManDataVO;

public class ExcelHelper {
	//public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	// static String[] HEADERs = { "Id", "Name","Father's Name", "Date", "Katla",
	// "Rohu", "Mrigal"};
	static String firstHeading = "Regional Manager, MP Fish Federation, Bhopal";
	static String secondHeading = "Daily Member wise Fish Production";
	static String thirdHeading = "Halali";
	static String[] Major_HEADERs = { "S. No.", "Id", "Name", "Father's Name", "Major", "Total Major",
			"Local Major Corp", "Total Local Major", "Minor", "Total Minor", "Grand Total" };
	static String[] Major_subHEADERs = { "Katla", "Rohu", "Mrigal", "Other Major Corp", " ", "Singhad",
			"Pabda/Cheetal/Sambal", "Kalvasu", " ", "Big Minor", "Minor" };
	static String[] quantity_weight_headers = { "Quantity", "Weight" };
	static String SHEET = "FisherMan Data";

	static final String INMTHD = "Inside ";
	static final String OUTMTHD = " Outside ";
	static final String ERROR = " Error in the ";
	static final String CLASS = " of Class ExcelHelper";
	final static Logger logger = LoggerFactory.getLogger(ExcelHelper.class);

	public static ByteArrayInputStream tutorialsToExcel(List<FisherManDataVO> tutorials) {
		logger.info(INMTHD + "tutorialsToExcel" + CLASS);

		try (Workbook workbook = new XSSFWorkbook()) {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			Sheet sheet = workbook.createSheet(SHEET);

			CellStyle style = workbook.createCellStyle();
			style.setAlignment(HorizontalAlignment.CENTER);
			style.setWrapText(true);
			style.setVerticalAlignment(VerticalAlignment.CENTER);
			style.setShrinkToFit(true);

			style.setBorderBottom(BorderStyle.THIN);
			style.setBorderTop(BorderStyle.THIN);
			style.setBorderLeft(BorderStyle.THIN);
			style.setBorderRight(BorderStyle.THIN);

			// First Heading
			Row firstRow = sheet.createRow(0);
			Cell firstCell = firstRow.createCell(0);
			firstCell.setCellValue(firstHeading);
			sheet.addMergedRegion(CellRangeAddress.valueOf("A" + 1 + ":AC" + 1));
			firstCell.setCellStyle(style);

			// Second Heading
			Row secondRow = sheet.createRow(1);
			firstCell = secondRow.createCell(0);
			firstCell.setCellValue(secondHeading);
			// firstCell.setCellStyle(style);
			sheet.addMergedRegion(CellRangeAddress.valueOf("A" + 2 + ":AC" + 2));

			// Third Heading
			Row thirdRow = sheet.createRow(2);
			firstCell = thirdRow.createCell(0);
			firstCell.setCellValue(thirdHeading);
			// firstCell.setCellStyle(style);
			sheet.addMergedRegion(CellRangeAddress.valueOf("A" + 3 + ":AC" + 3));

			// Header Row --- fourth row
			Row headerRow = sheet.createRow(3);
			int subHeadingCount = 0;

			sheet.addMergedRegion(CellRangeAddress.valueOf("E" + 4 + ":L" + 4));
			sheet.addMergedRegion(CellRangeAddress.valueOf("M" + 4 + ":N" + 4));
			sheet.addMergedRegion(CellRangeAddress.valueOf("O" + 4 + ":T" + 4));
			sheet.addMergedRegion(CellRangeAddress.valueOf("U" + 4 + ":V" + 4));
			sheet.addMergedRegion(CellRangeAddress.valueOf("W" + 4 + ":Y" + 4));
			sheet.addMergedRegion(CellRangeAddress.valueOf("Z" + 4 + ":AA" + 4));
			sheet.addMergedRegion(CellRangeAddress.valueOf("AB" + 4 + ":AC" + 4));

			int col = 0;
			for (int headCol = 0; headCol < Major_HEADERs.length; headCol++) {
				Cell cell = headerRow.createCell(col);
				// cell.setCellStyle(style);

				cell.setCellValue(Major_HEADERs[headCol]);
				logger.info("Major Column *** col number = " + col);
				logger.info("Major Column *** col Value = " + Major_HEADERs[headCol]);

				if (col == 4) {
					col = col + 7;
				} else if (col == 12) {
					// cell.setCellStyle(totalColStyle);
					col = col + 1;

				} else if (col == 14) {
					col = col + 5;

				} else if (col == 18) {
					col = col + 1;

				} else if (col == 20) {
					col = col + 1;

				} else if (col == 22) {
					col = col + 2;

				} else if (col == 25) {
					col = col + 1;

				}

				col++;

			}

			// fifth row

			Row fifthRow = sheet.createRow(4);
			col = 4;
			for (int subCol = 0; subCol < Major_subHEADERs.length; subCol++) {
				Cell subCell = fifthRow.createCell(col);
				// subCell.setCellStyle(style);
				/*
				 * if(subCol==6) { }
				 */
				logger.info("Sub Column *** sub col number = " + subCol);
				logger.info("subHeadingCount : " + subHeadingCount);

				subCell.setCellValue(Major_subHEADERs[subCol]);
				logger.info("Sub Column *** sub col value = " + subCell.getStringCellValue());
				subHeadingCount++;
				col = col + 2;

			}

			// sixth row
			// Number and weight Row
			Row sixthRow = sheet.createRow(5);
			int quantity_weight_column = 4;
			for (int i = 1; i <= 13; i++) {
				for (int j = 0; j <= 1; j++) {
					Cell subCell = sixthRow.createCell(quantity_weight_column);
					logger.info("Sixth Row ** Column num = " + quantity_weight_column);

					// subCell.setCellStyle(style);
					quantity_weight_column++;
					if (i == 11) {
						subCell.setCellValue(quantity_weight_headers[1]);
						j++;
					} else
						subCell.setCellValue(quantity_weight_headers[j]);

				}
			}
			sheet.addMergedRegion(CellRangeAddress.valueOf("E" + 5 + ":F" + 5));
			sheet.addMergedRegion(CellRangeAddress.valueOf("G" + 5 + ":H" + 5));
			sheet.addMergedRegion(CellRangeAddress.valueOf("I" + 5 + ":J" + 5));
			sheet.addMergedRegion(CellRangeAddress.valueOf("K" + 5 + ":L" + 5));

			sheet.addMergedRegion(CellRangeAddress.valueOf("M" + 5 + ":N" + 5));
			sheet.addMergedRegion(CellRangeAddress.valueOf("O" + 5 + ":P" + 5));
			sheet.addMergedRegion(CellRangeAddress.valueOf("Q" + 5 + ":R" + 5));
			sheet.addMergedRegion(CellRangeAddress.valueOf("S" + 5 + ":T" + 5));
			sheet.addMergedRegion(CellRangeAddress.valueOf("U" + 5 + ":V" + 5));
			sheet.addMergedRegion(CellRangeAddress.valueOf("W" + 5 + ":X" + 5));
			sheet.addMergedRegion(CellRangeAddress.valueOf("Z" + 5 + ":AA" + 5));
			sheet.addMergedRegion(CellRangeAddress.valueOf("AB" + 5 + ":AC" + 5));

			int rowIdx = 6;
			int sNo = 0;
			int totalKatla = 0;
			int totalRohu = 0;
			int totalMrigal = 0;
			int totalOtherMaj = 0;
			int totalKRM = 0;
			int totalSinghad = 0;
			int totalPabCheetSambKal = 0;
			int totalKalvasu = 0;
			int totalTotalLocalMaj = 0;
			int totalBigMinor = 0;
			int totalTotalMinor = 0;
			int totalGrandTotal = 0;

			Double totalKatlaWt = 0.0;
			Double totalRohuWt = 0.0;
			Double totalMrigalWt = 0.0;
			Double totalOtherMajWt = 0.0;
			Double totalKRMWt = 0.0;
			Double totalSinghadWt = 0.0;
			Double totalPabCheetSambKalWt = 0.0;
			Double totalKalvasuWt = 0.0;
			Double totalTotalLocalMajWt = 0.0;
			Double totalBigMinorWt = 0.0;
			Double totalMinorWt = 0.0;
			Double totalTotalMinorWt = 0.0;
			Double totalGrandTotalWt = 0.0;

			for (FisherManDataVO tutorial : tutorials) {
				Row row = sheet.createRow(rowIdx++);
				// row.setRowStyle(style);
				sNo++;

				row.createCell(0).setCellValue(sNo);
				row.createCell(1).setCellValue(tutorial.getFisherManId());
				row.createCell(2).setCellValue(tutorial.getFisherManName());

				row.createCell(3).setCellValue(tutorial.getFisherManFatherName());

				if (tutorial.getKatla() != null) {
					row.createCell(4).setCellValue(tutorial.getKatla());
					totalKatla = totalKatla + tutorial.getKatla();
				} else
					row.createCell(4).setCellValue("0");

				if (tutorial.getKatlaWt() != null) {
					row.createCell(5).setCellValue(tutorial.getKatlaWt());
					totalKatlaWt = totalKatlaWt + tutorial.getKatlaWt();
				} else
					row.createCell(5).setCellValue("0");

				if (tutorial.getRohu() != null) {
					row.createCell(6).setCellValue(tutorial.getRohu());
					totalRohu = totalRohu + tutorial.getRohu();
				} else
					row.createCell(6).setCellValue("0");

				if (tutorial.getRohuWt() != null) {
					row.createCell(7).setCellValue(tutorial.getRohuWt());
					totalRohuWt = totalRohuWt + tutorial.getRohuWt();
				} else
					row.createCell(7).setCellValue("0");

				if (tutorial.getMrigal() != null) {
					row.createCell(8).setCellValue(tutorial.getMrigal());
					totalMrigal = totalMrigal + tutorial.getMrigal();
				} else
					row.createCell(8).setCellValue("0");

				if (tutorial.getMrigalWt() != null) {
					row.createCell(9).setCellValue(tutorial.getMrigalWt());
					totalMrigalWt = totalMrigalWt + tutorial.getMrigalWt();
				} else
					row.createCell(9).setCellValue("0");

				if (tutorial.getOtherMjrCorp() != null) {
					row.createCell(10).setCellValue(tutorial.getOtherMjrCorp());
					totalOtherMaj = totalOtherMaj + tutorial.getOtherMjrCorp();
				} else
					row.createCell(10).setCellValue("0");

				if (tutorial.getOtherMjrCorpWt() != null) {
					row.createCell(11).setCellValue(tutorial.getOtherMjrCorpWt());
					totalOtherMajWt = totalOtherMajWt + tutorial.getOtherMjrCorpWt();
				} else
					row.createCell(11).setCellValue("0");

				if (tutorial.getTotalKRM() != null) {
					row.createCell(12).setCellValue(tutorial.getTotalKRM());
					totalKRM = totalKRM + tutorial.getTotalKRM();
				} else
					row.createCell(12).setCellValue("0");

				if (tutorial.getTotalKRMWt() != null) {
					row.createCell(13).setCellValue(tutorial.getTotalKRMWt());
					totalKRMWt = totalKRMWt + tutorial.getTotalKRMWt();
				} else
					row.createCell(13).setCellValue("0");

				if (tutorial.getSinghad() != null) {
					row.createCell(14).setCellValue(tutorial.getSinghad());
					totalSinghad = totalSinghad + tutorial.getSinghad();
				} else
					row.createCell(14).setCellValue("0");

				if (tutorial.getSinghadWt() != null) {
					row.createCell(15).setCellValue(tutorial.getSinghadWt());
					totalSinghadWt = totalSinghadWt + tutorial.getSinghadWt();
				} else
					row.createCell(15).setCellValue("0");

				if (tutorial.getPabCheetSambKal() != null) {
					row.createCell(16).setCellValue(tutorial.getPabCheetSambKal());
					totalPabCheetSambKal = totalPabCheetSambKal + tutorial.getPabCheetSambKal();
				} else
					row.createCell(16).setCellValue("0");

				if (tutorial.getPabCheetSambKalWt() != null) {
					row.createCell(17).setCellValue(tutorial.getPabCheetSambKalWt());
					totalPabCheetSambKalWt = totalPabCheetSambKalWt + tutorial.getPabCheetSambKalWt();
				} else
					row.createCell(17).setCellValue("0");

				// Kalvasu
				if (tutorial.getKalvasu() != null) {
					row.createCell(18).setCellValue(tutorial.getKalvasu());
					totalKalvasu = totalKalvasu + tutorial.getKalvasu();
				} else
					row.createCell(18).setCellValue("0");

				if (tutorial.getKalvasuWt() != null) {
					row.createCell(19).setCellValue(tutorial.getKalvasuWt());
					totalKalvasuWt = totalKalvasuWt + tutorial.getKalvasuWt();
				} else
					row.createCell(19).setCellValue("0");

				// Total Local Major
				if (tutorial.getTotalLocalMaj() != null) {
					row.createCell(20).setCellValue(tutorial.getTotalLocalMaj());
					totalTotalLocalMaj = totalTotalLocalMaj + tutorial.getTotalLocalMaj();
				} else
					row.createCell(20).setCellValue("0");

				if (tutorial.getTotalLocalMajWt() != null) {
					row.createCell(21).setCellValue(tutorial.getTotalLocalMajWt());
					totalTotalLocalMajWt = totalTotalLocalMajWt + tutorial.getTotalLocalMajWt();
				} else
					row.createCell(21).setCellValue("0");

				// Minor
				if (tutorial.getBigMinor() != null) {
					row.createCell(22).setCellValue(tutorial.getBigMinor());
					totalBigMinor = totalBigMinor + tutorial.getBigMinor();
				} else
					row.createCell(22).setCellValue("0");

				if (tutorial.getBigMinorWt() != null) {
					row.createCell(23).setCellValue(tutorial.getBigMinorWt());
					totalBigMinorWt = totalBigMinorWt + tutorial.getBigMinorWt();
				} else
					row.createCell(23).setCellValue("0");

				if (tutorial.getMinorWt() != null) {
					row.createCell(24).setCellValue(tutorial.getMinorWt());
					totalMinorWt = totalMinorWt + tutorial.getMinorWt();
				} else
					row.createCell(24).setCellValue("0");

				// Total Minor
				if (tutorial.getTotalMinor() != null) {
					row.createCell(25).setCellValue(tutorial.getTotalMinor());
					totalTotalMinor = totalTotalMinor + tutorial.getTotalMinor();
				} else
					row.createCell(25).setCellValue("0");

				if (tutorial.getTotalMinorWt() != null) {
					row.createCell(26).setCellValue(tutorial.getTotalMinorWt());
					totalTotalMinorWt = totalTotalMinorWt + tutorial.getTotalMinorWt();
				} else
					row.createCell(26).setCellValue("0");

				// Grand Total
				if (tutorial.getGrandTotal() != null) {
					row.createCell(27).setCellValue(tutorial.getGrandTotal());
					totalGrandTotal = totalGrandTotal + tutorial.getGrandTotal();
				} else
					row.createCell(27).setCellValue("0");

				if (tutorial.getGrandTotalWt() != null) {
					row.createCell(28).setCellValue(tutorial.getGrandTotalWt());
					totalGrandTotalWt = totalGrandTotalWt + tutorial.getGrandTotalWt();
				} else
					row.createCell(28).setCellValue("0");

			}

			Row totalRow = sheet.createRow(rowIdx++);
			
			int colNum = 4;

			double[] values = { totalKatla, totalKatlaWt, totalRohu, totalRohuWt, totalMrigal, totalMrigalWt,
					totalOtherMaj, totalOtherMajWt, totalKRM, totalKRMWt, totalSinghad, totalSinghadWt,
					totalPabCheetSambKal, totalPabCheetSambKalWt, totalKalvasu, totalKalvasuWt, totalTotalLocalMaj,
					totalTotalLocalMajWt, totalBigMinor, totalBigMinorWt, totalMinorWt, totalTotalMinor,
					totalTotalMinorWt, totalGrandTotal, totalGrandTotalWt };

			for (double value : values) {

				Cell subCell = totalRow.createCell(colNum++);
				subCell.setCellValue(value);

				// Create or get cell style and font
				CellStyle cellStyle = subCell.getCellStyle();
				if (cellStyle == null) {
					cellStyle = subCell.getSheet().getWorkbook().createCellStyle();
					subCell.setCellStyle(cellStyle);
				}				
			}

			sheet.autoSizeColumn(3);
			sheet.autoSizeColumn(2);
			sheet.setHorizontallyCenter(true);

			// Set borders for the entire sheet
			setSheetBorders(sheet, BorderStyle.THIN, style, 12, workbook, totalRow);

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		}
	}

	private static void setSheetBorders(Sheet sheet, BorderStyle borderStyle, CellStyle style, int columnIndex,
			Workbook workbook, Row totalRow) {
		// Create a new CellStyle for the borders
		CellStyle borderStyle1 = workbook.createCellStyle();
		borderStyle1.setBorderBottom(BorderStyle.THIN);
		borderStyle1.setBorderTop(BorderStyle.THIN);
		borderStyle1.setBorderLeft(BorderStyle.THIN);
		borderStyle1.setBorderRight(BorderStyle.THIN);

		// Iterate through all rows in the sheet and apply the style
		for (Row row : sheet) {
			// Apply the border style to the specific cells

			// Apply the main style to all cells
			for (Cell cell : row) {
				cell.setCellStyle(style);
			}

			// If the cell is part of a merged region, apply the style to the merged region
			// as well
			List<CellRangeAddress> mergedRegions = sheet.getMergedRegions();
			for (CellRangeAddress rangeAddress : mergedRegions) {
				RegionUtil.setBorderTop(BorderStyle.THIN, rangeAddress, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, rangeAddress, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, rangeAddress, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, rangeAddress, sheet);
			}

			// Colour for last row
			if (row.getRowNum() == sheet.getLastRowNum()) {
                colorForLastRow(row, borderStyle1);
            }
			applyBorderStyleToCell(row, columnIndex, borderStyle1);

		}
	}

	private static void colorForLastRow(Row totalRow, CellStyle borderStyle1) {
        borderStyle1.setFillForegroundColor(IndexedColors.AQUA.getIndex());
        borderStyle1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        borderStyle1.setAlignment(HorizontalAlignment.CENTER);

        Font font = totalRow.getSheet().getWorkbook().createFont();
        font.setBold(true);
        borderStyle1.setFont(font);

        for (Cell cell : totalRow) {
            cell.setCellStyle(borderStyle1);
        }
    }

	private static void applyBorderStyleToCell(Row row, int columnIndex, CellStyle borderStyle) {
		borderStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
		borderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		borderStyle.setAlignment(HorizontalAlignment.CENTER);
		Cell cell = row.getCell(columnIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
		cell.setCellStyle(borderStyle);
		cell = row.getCell(columnIndex + 1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
		cell.setCellStyle(borderStyle);
		cell = row.getCell(columnIndex + 8, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
		cell.setCellStyle(borderStyle);
		cell = row.getCell(columnIndex + 9, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
		cell.setCellStyle(borderStyle);
		cell = row.getCell(columnIndex + 13, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
		cell.setCellStyle(borderStyle);
		cell = row.getCell(columnIndex + 14, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
		cell.setCellStyle(borderStyle);
	}

}
