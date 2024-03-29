USE [DKHocPhan_final]
GO
/****** Object:  Table [dbo].[ChucVu]    Script Date: 3/13/2023 9:27:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChucVu](
	[MaChucVu] [nvarchar](20) NOT NULL,
	[TenChucVu] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_ChucVu] PRIMARY KEY CLUSTERED 
(
	[MaChucVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CT_HocKy_NamHoc]    Script Date: 3/13/2023 9:27:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CT_HocKy_NamHoc](
	[ID_CTHKNH] [int] IDENTITY(1,1) NOT NULL,
	[MaHocKy] [int] NOT NULL,
	[MaNamHoc] [int] NOT NULL,
	[IDGTC] [int] NOT NULL,
	[NgayBatDau] [date] NOT NULL,
	[NgayKetThuc] [date] NOT NULL,
 CONSTRAINT [PK_CT_HocKy_NamHoc] PRIMARY KEY CLUSTERED 
(
	[ID_CTHKNH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CT_Nhom]    Script Date: 3/13/2023 9:27:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CT_Nhom](
	[IDCTN] [int] IDENTITY(1,1) NOT NULL,
	[MaNhom] [int] NOT NULL,
	[MaLopTC] [nvarchar](20) NOT NULL,
	[SoLuongTD] [int] NOT NULL,
	[SoLuongDaDK] [int] NOT NULL,
	[MaPNCThucHanh] [int] NULL,
 CONSTRAINT [PK_CT_Nhom_1] PRIMARY KEY CLUSTERED 
(
	[IDCTN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DangKy]    Script Date: 3/13/2023 9:27:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DangKy](
	[MaSV] [nvarchar](20) NOT NULL,
	[IDCTN] [int] NOT NULL,
 CONSTRAINT [PK_DangKy] PRIMARY KEY CLUSTERED 
(
	[MaSV] ASC,
	[IDCTN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DayLop]    Script Date: 3/13/2023 9:27:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DayLop](
	[MaLopTC] [nvarchar](20) NOT NULL,
	[MaGV] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_DayLop] PRIMARY KEY CLUSTERED 
(
	[MaLopTC] ASC,
	[MaGV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GiangVien]    Script Date: 3/13/2023 9:27:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GiangVien](
	[MaGV] [nvarchar](20) NOT NULL,
	[Ho] [nvarchar](20) NOT NULL,
	[Tendem] [nvarchar](20) NULL,
	[Ten] [nvarchar](20) NOT NULL,
	[Phai] [bit] NOT NULL,
	[NgaySinh] [date] NOT NULL,
	[SoDienThoai_1] [nvarchar](12) NOT NULL,
	[SoDienThoai_2] [nvarchar](12) NULL,
	[Email_1] [nvarchar](50) NOT NULL,
	[Email_2] [nvarchar](50) NULL,
	[MaHocVi] [nvarchar](20) NOT NULL,
	[NghiLam] [bit] NOT NULL,
	[GhiChu] [text] NULL,
	[MaQQ] [int] NOT NULL,
 CONSTRAINT [PK_GiangVien] PRIMARY KEY CLUSTERED 
(
	[MaGV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GiaTinChi]    Script Date: 3/13/2023 9:27:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GiaTinChi](
	[IDGTC] [int] IDENTITY(1,1) NOT NULL,
	[GiaTien] [money] NOT NULL,
	[LichSu] [date] NULL,
 CONSTRAINT [PK_GiaTinChi] PRIMARY KEY CLUSTERED 
(
	[IDGTC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HocKy]    Script Date: 3/13/2023 9:27:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HocKy](
	[MaHocKy] [int] IDENTITY(1,1) NOT NULL,
	[TenHocKy] [nvarchar](15) NOT NULL,
 CONSTRAINT [PK_HocKy] PRIMARY KEY CLUSTERED 
(
	[MaHocKy] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HocVi]    Script Date: 3/13/2023 9:27:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HocVi](
	[MaHocVi] [nvarchar](20) NOT NULL,
	[TenHocVi] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_HocVi] PRIMARY KEY CLUSTERED 
(
	[MaHocVi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LichSuGia]    Script Date: 3/13/2023 9:27:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LichSuGia](
	[IDLS] [int] IDENTITY(1,1) NOT NULL,
	[ThoiGianCapNhat] [nchar](10) NULL,
	[MaNganh] [int] NULL,
	[GiaThayDoi] [nchar](10) NULL,
 CONSTRAINT [PK_LichSuGia] PRIMARY KEY CLUSTERED 
(
	[IDLS] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LopTinChi]    Script Date: 3/13/2023 9:27:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LopTinChi](
	[MaLopTC] [nvarchar](20) NOT NULL,
	[ID_CTHKNH] [int] NOT NULL,
	[MaPNCLyThuyet] [int] NOT NULL,
	[SoNhomTH] [int] NOT NULL,
	[MaMH] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_LopTinChi] PRIMARY KEY CLUSTERED 
(
	[MaLopTC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MonHoc]    Script Date: 3/13/2023 9:27:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MonHoc](
	[MaMH] [nvarchar](20) NOT NULL,
	[TenMH] [nvarchar](50) NOT NULL,
	[SoTinChi] [int] NOT NULL,
 CONSTRAINT [PK_MonHoc] PRIMARY KEY CLUSTERED 
(
	[MaMH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NamHoc]    Script Date: 3/13/2023 9:27:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NamHoc](
	[MaNamHoc] [int] IDENTITY(1,1) NOT NULL,
	[TenNamHoc] [nchar](10) NOT NULL,
 CONSTRAINT [PK_NamHoc] PRIMARY KEY CLUSTERED 
(
	[MaNamHoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Nganh]    Script Date: 3/13/2023 9:27:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Nganh](
	[MaNganh] [int] NOT NULL,
	[TenNganh] [nvarchar](50) NOT NULL,
	[GiaHienThoi] [nchar](10) NULL,
 CONSTRAINT [PK_Nganh] PRIMARY KEY CLUSTERED 
(
	[MaNganh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVienPDT]    Script Date: 3/13/2023 9:27:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVienPDT](
	[MaNV] [nvarchar](20) NOT NULL,
	[Ho] [nvarchar](20) NOT NULL,
	[TenDem] [nvarchar](20) NULL,
	[Phai] [bit] NOT NULL,
	[Ten] [nvarchar](20) NOT NULL,
	[SoDienThoai] [nchar](10) NOT NULL,
	[Email] [nvarchar](50) NOT NULL,
	[MaQQ] [int] NOT NULL,
	[NghiLam] [bit] NOT NULL,
 CONSTRAINT [PK_NhanVienPDT] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Nhom]    Script Date: 3/13/2023 9:27:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Nhom](
	[MaNhom] [int] IDENTITY(1,1) NOT NULL,
	[TenNhom] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_Nhom] PRIMARY KEY CLUSTERED 
(
	[MaNhom] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Phien]    Script Date: 3/13/2023 9:27:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Phien](
	[MaPhien] [int] IDENTITY(1,1) NOT NULL,
	[NgayBatDau] [date] NOT NULL,
	[NgayKetThuc] [date] NOT NULL,
	[ID_CTHKNH] [int] NOT NULL,
 CONSTRAINT [PK_Phien] PRIMARY KEY CLUSTERED 
(
	[MaPhien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Phong_Ngay_Ca]    Script Date: 3/13/2023 9:27:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Phong_Ngay_Ca](
	[MaPNC] [int] IDENTITY(1,1) NOT NULL,
	[TietBatDau] [int] NOT NULL,
	[NgayBatDau] [date] NOT NULL,
	[NgayKetThuc] [date] NOT NULL,
	[Phong] [nvarchar](10) NOT NULL,
	[ThuTrongTuan] [int] NOT NULL,
 CONSTRAINT [PK_PNC] PRIMARY KEY CLUSTERED 
(
	[MaPNC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[QueQuan]    Script Date: 3/13/2023 9:27:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[QueQuan](
	[MaQQ] [int] NOT NULL,
	[TenQQ] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_QueQuan] PRIMARY KEY CLUSTERED 
(
	[MaQQ] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SinhVien]    Script Date: 3/13/2023 9:27:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SinhVien](
	[MaSV] [nvarchar](20) NOT NULL,
	[Ho] [nvarchar](20) NOT NULL,
	[TenDem] [nvarchar](20) NULL,
	[Ten] [nvarchar](20) NOT NULL,
	[Phai] [bit] NOT NULL,
	[NgaySinh] [date] NOT NULL,
	[LopKhoaHoc] [nvarchar](20) NOT NULL,
	[ChuongTrinhDaoTao] [nvarchar](20) NOT NULL,
	[SoDienThoai_1] [nvarchar](12) NOT NULL,
	[SoDienThoai_2] [nvarchar](12) NULL,
	[Email_1] [nvarchar](50) NOT NULL,
	[Email_2] [nvarchar](50) NULL,
	[NghiHoc] [bit] NOT NULL,
	[MaNganh] [int] NULL,
	[MaQQ] [int] NULL,
 CONSTRAINT [PK_SinhVien] PRIMARY KEY CLUSTERED 
(
	[MaSV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 3/13/2023 9:27:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[TaiKhoan] [nvarchar](20) NOT NULL,
	[MatKhau] [nvarchar](50) NOT NULL,
	[TrangThai] [bit] NOT NULL,
	[MaChucVu] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[TaiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[ChucVu] ([MaChucVu], [TenChucVu]) VALUES (N'NV', N'NhanVien')
INSERT [dbo].[ChucVu] ([MaChucVu], [TenChucVu]) VALUES (N'SV', N'SinhVien')
GO
SET IDENTITY_INSERT [dbo].[CT_HocKy_NamHoc] ON 

INSERT [dbo].[CT_HocKy_NamHoc] ([ID_CTHKNH], [MaHocKy], [MaNamHoc], [IDGTC], [NgayBatDau], [NgayKetThuc]) VALUES (1, 1, 1, 1, CAST(N'2019-08-15' AS Date), CAST(N'2020-01-01' AS Date))
INSERT [dbo].[CT_HocKy_NamHoc] ([ID_CTHKNH], [MaHocKy], [MaNamHoc], [IDGTC], [NgayBatDau], [NgayKetThuc]) VALUES (2, 2, 1, 1, CAST(N'2020-01-02' AS Date), CAST(N'2020-06-25' AS Date))
INSERT [dbo].[CT_HocKy_NamHoc] ([ID_CTHKNH], [MaHocKy], [MaNamHoc], [IDGTC], [NgayBatDau], [NgayKetThuc]) VALUES (4, 1, 2, 2, CAST(N'2020-08-15' AS Date), CAST(N'2021-08-15' AS Date))
INSERT [dbo].[CT_HocKy_NamHoc] ([ID_CTHKNH], [MaHocKy], [MaNamHoc], [IDGTC], [NgayBatDau], [NgayKetThuc]) VALUES (5, 2, 2, 2, CAST(N'2021-01-02' AS Date), CAST(N'2021-06-25' AS Date))
INSERT [dbo].[CT_HocKy_NamHoc] ([ID_CTHKNH], [MaHocKy], [MaNamHoc], [IDGTC], [NgayBatDau], [NgayKetThuc]) VALUES (6, 2, 3, 2, CAST(N'2022-01-02' AS Date), CAST(N'2022-06-25' AS Date))
SET IDENTITY_INSERT [dbo].[CT_HocKy_NamHoc] OFF
GO
SET IDENTITY_INSERT [dbo].[CT_Nhom] ON 

INSERT [dbo].[CT_Nhom] ([IDCTN], [MaNhom], [MaLopTC], [SoLuongTD], [SoLuongDaDK], [MaPNCThucHanh]) VALUES (1, 1, N'THCS1', 30, 0, 1)
INSERT [dbo].[CT_Nhom] ([IDCTN], [MaNhom], [MaLopTC], [SoLuongTD], [SoLuongDaDK], [MaPNCThucHanh]) VALUES (2, 2, N'THCS1', 40, 0, 2)
INSERT [dbo].[CT_Nhom] ([IDCTN], [MaNhom], [MaLopTC], [SoLuongTD], [SoLuongDaDK], [MaPNCThucHanh]) VALUES (3, 3, N'THCS1', 30, 0, 3)
INSERT [dbo].[CT_Nhom] ([IDCTN], [MaNhom], [MaLopTC], [SoLuongTD], [SoLuongDaDK], [MaPNCThucHanh]) VALUES (4, 1, N'GDTC1', 70, 0, 4)
INSERT [dbo].[CT_Nhom] ([IDCTN], [MaNhom], [MaLopTC], [SoLuongTD], [SoLuongDaDK], [MaPNCThucHanh]) VALUES (5, 1, N'GDQP1', 75, 0, 5)
INSERT [dbo].[CT_Nhom] ([IDCTN], [MaNhom], [MaLopTC], [SoLuongTD], [SoLuongDaDK], [MaPNCThucHanh]) VALUES (7, 1, N'THMAC', 30, 0, 6)
INSERT [dbo].[CT_Nhom] ([IDCTN], [MaNhom], [MaLopTC], [SoLuongTD], [SoLuongDaDK], [MaPNCThucHanh]) VALUES (8, 1, N'GT1', 30, 0, 7)
INSERT [dbo].[CT_Nhom] ([IDCTN], [MaNhom], [MaLopTC], [SoLuongTD], [SoLuongDaDK], [MaPNCThucHanh]) VALUES (9, 1, N'KTMT', 40, 0, 7)
INSERT [dbo].[CT_Nhom] ([IDCTN], [MaNhom], [MaLopTC], [SoLuongTD], [SoLuongDaDK], [MaPNCThucHanh]) VALUES (10, 1, N'ATHT', 85, 0, 2)
INSERT [dbo].[CT_Nhom] ([IDCTN], [MaNhom], [MaLopTC], [SoLuongTD], [SoLuongDaDK], [MaPNCThucHanh]) VALUES (11, 2, N'ATHT', 90, 0, 3)
INSERT [dbo].[CT_Nhom] ([IDCTN], [MaNhom], [MaLopTC], [SoLuongTD], [SoLuongDaDK], [MaPNCThucHanh]) VALUES (12, 1, N'DLPT', 90, 0, 9)
INSERT [dbo].[CT_Nhom] ([IDCTN], [MaNhom], [MaLopTC], [SoLuongTD], [SoLuongDaDK], [MaPNCThucHanh]) VALUES (13, 1, N'CNPM', 85, 0, 9)
INSERT [dbo].[CT_Nhom] ([IDCTN], [MaNhom], [MaLopTC], [SoLuongTD], [SoLuongDaDK], [MaPNCThucHanh]) VALUES (14, 1, N'LTW', 30, 0, 9)
INSERT [dbo].[CT_Nhom] ([IDCTN], [MaNhom], [MaLopTC], [SoLuongTD], [SoLuongDaDK], [MaPNCThucHanh]) VALUES (15, 2, N'LTW', 30, 0, 10)
INSERT [dbo].[CT_Nhom] ([IDCTN], [MaNhom], [MaLopTC], [SoLuongTD], [SoLuongDaDK], [MaPNCThucHanh]) VALUES (16, 3, N'LTW', 40, 0, 11)
INSERT [dbo].[CT_Nhom] ([IDCTN], [MaNhom], [MaLopTC], [SoLuongTD], [SoLuongDaDK], [MaPNCThucHanh]) VALUES (17, 1, N'TLVB', 99, 0, 9)
INSERT [dbo].[CT_Nhom] ([IDCTN], [MaNhom], [MaLopTC], [SoLuongTD], [SoLuongDaDK], [MaPNCThucHanh]) VALUES (18, 1, N'TTCS', 89, 0, 9)
INSERT [dbo].[CT_Nhom] ([IDCTN], [MaNhom], [MaLopTC], [SoLuongTD], [SoLuongDaDK], [MaPNCThucHanh]) VALUES (19, 1, N'TTNT', 99, 0, 9)
INSERT [dbo].[CT_Nhom] ([IDCTN], [MaNhom], [MaLopTC], [SoLuongTD], [SoLuongDaDK], [MaPNCThucHanh]) VALUES (22, 1, N'ATHT02', 30, 0, 16)
SET IDENTITY_INSERT [dbo].[CT_Nhom] OFF
GO
INSERT [dbo].[DangKy] ([MaSV], [IDCTN]) VALUES (N'n20dccn027', 11)
INSERT [dbo].[DangKy] ([MaSV], [IDCTN]) VALUES (N'n20dccn027', 12)
INSERT [dbo].[DangKy] ([MaSV], [IDCTN]) VALUES (N'n20dccn027', 13)
INSERT [dbo].[DangKy] ([MaSV], [IDCTN]) VALUES (N'n20dccn027', 14)
INSERT [dbo].[DangKy] ([MaSV], [IDCTN]) VALUES (N'n20dccn027', 18)
GO
INSERT [dbo].[DayLop] ([MaLopTC], [MaGV]) VALUES (N'ATHT02', N'GV480202')
INSERT [dbo].[DayLop] ([MaLopTC], [MaGV]) VALUES (N'ATHT02', N'GV480204')
INSERT [dbo].[DayLop] ([MaLopTC], [MaGV]) VALUES (N'DS1', N'GV480202')
INSERT [dbo].[DayLop] ([MaLopTC], [MaGV]) VALUES (N'DS1', N'GV480203')
GO
INSERT [dbo].[GiangVien] ([MaGV], [Ho], [Tendem], [Ten], [Phai], [NgaySinh], [SoDienThoai_1], [SoDienThoai_2], [Email_1], [Email_2], [MaHocVi], [NghiLam], [GhiChu], [MaQQ]) VALUES (N'GV480201', N'Tân', NULL, N'Hạnh', 0, CAST(N'1940-01-01' AS Date), N'0908444222', NULL, N'tanhanh@ptithcm.edu.vn     ', NULL, N'TS', 0, NULL, 222)
INSERT [dbo].[GiangVien] ([MaGV], [Ho], [Tendem], [Ten], [Phai], [NgaySinh], [SoDienThoai_1], [SoDienThoai_2], [Email_1], [Email_2], [MaHocVi], [NghiLam], [GhiChu], [MaQQ]) VALUES (N'GV480202', N'Lưu', N'Nguyễn Kỳ', N'Thư', 1, CAST(N'1940-01-01' AS Date), N'0908444111', NULL, N'lnkthu@ptith', NULL, N'TS', 0, NULL, 222)
INSERT [dbo].[GiangVien] ([MaGV], [Ho], [Tendem], [Ten], [Phai], [NgaySinh], [SoDienThoai_1], [SoDienThoai_2], [Email_1], [Email_2], [MaHocVi], [NghiLam], [GhiChu], [MaQQ]) VALUES (N'GV480203', N'Nguyễn', N'Trọng', N'Sơn', 1, CAST(N'1940-01-01' AS Date), N'0231242324', NULL, N'nts@ptithcm.edu.vn', NULL, N'TS', 0, NULL, 222)
INSERT [dbo].[GiangVien] ([MaGV], [Ho], [Tendem], [Ten], [Phai], [NgaySinh], [SoDienThoai_1], [SoDienThoai_2], [Email_1], [Email_2], [MaHocVi], [NghiLam], [GhiChu], [MaQQ]) VALUES (N'GV480204', N'Nguyễn', N'Thị', N'Hải', 1, CAST(N'1940-01-01' AS Date), N'0335555555', NULL, N'nthai@ptithcm.edu.vn', NULL, N'TS', 0, NULL, 222)
INSERT [dbo].[GiangVien] ([MaGV], [Ho], [Tendem], [Ten], [Phai], [NgaySinh], [SoDienThoai_1], [SoDienThoai_2], [Email_1], [Email_2], [MaHocVi], [NghiLam], [GhiChu], [MaQQ]) VALUES (N'GV480205', N'Huỳnh', N'Trọng', N'Thưa', 1, CAST(N'1950-01-01' AS Date), N'0357777777', NULL, N'htthua@ptithcm.edu.vn', NULL, N'TS', 0, NULL, 204)
INSERT [dbo].[GiangVien] ([MaGV], [Ho], [Tendem], [Ten], [Phai], [NgaySinh], [SoDienThoai_1], [SoDienThoai_2], [Email_1], [Email_2], [MaHocVi], [NghiLam], [GhiChu], [MaQQ]) VALUES (N'GV480206', N'Huỳnh', N'Thanh', N'Tâm', 1, CAST(N'1989-01-01' AS Date), N'0357777778', NULL, N'httam@ptithcm.edu.vn', NULL, N'TS', 0, NULL, 204)
GO
SET IDENTITY_INSERT [dbo].[GiaTinChi] ON 

INSERT [dbo].[GiaTinChi] ([IDGTC], [GiaTien], [LichSu]) VALUES (1, 480.0000, NULL)
INSERT [dbo].[GiaTinChi] ([IDGTC], [GiaTien], [LichSu]) VALUES (2, 550.0000, NULL)
SET IDENTITY_INSERT [dbo].[GiaTinChi] OFF
GO
SET IDENTITY_INSERT [dbo].[HocKy] ON 

INSERT [dbo].[HocKy] ([MaHocKy], [TenHocKy]) VALUES (1, N'Học Kỳ 1')
INSERT [dbo].[HocKy] ([MaHocKy], [TenHocKy]) VALUES (2, N'Học Kỳ 2')
INSERT [dbo].[HocKy] ([MaHocKy], [TenHocKy]) VALUES (3, N'Học Kỳ Hè')
SET IDENTITY_INSERT [dbo].[HocKy] OFF
GO
INSERT [dbo].[HocVi] ([MaHocVi], [TenHocVi]) VALUES (N'TS', N'Tien si')
GO
SET IDENTITY_INSERT [dbo].[LichSuGia] ON 

INSERT [dbo].[LichSuGia] ([IDLS], [ThoiGianCapNhat], [MaNganh], [GiaThayDoi]) VALUES (1, N'2023-01-20', 480101, N'550       ')
INSERT [dbo].[LichSuGia] ([IDLS], [ThoiGianCapNhat], [MaNganh], [GiaThayDoi]) VALUES (2, N'2023-01-20', 480201, N'550       ')
INSERT [dbo].[LichSuGia] ([IDLS], [ThoiGianCapNhat], [MaNganh], [GiaThayDoi]) VALUES (3, N'2023-01-20', 480301, N'550       ')
INSERT [dbo].[LichSuGia] ([IDLS], [ThoiGianCapNhat], [MaNganh], [GiaThayDoi]) VALUES (4, N'2023-01-20', 480302, N'550       ')
INSERT [dbo].[LichSuGia] ([IDLS], [ThoiGianCapNhat], [MaNganh], [GiaThayDoi]) VALUES (5, N'2023-01-20', 480303, N'550       ')
INSERT [dbo].[LichSuGia] ([IDLS], [ThoiGianCapNhat], [MaNganh], [GiaThayDoi]) VALUES (6, N'2023-01-20', 480401, N'550       ')
INSERT [dbo].[LichSuGia] ([IDLS], [ThoiGianCapNhat], [MaNganh], [GiaThayDoi]) VALUES (7, N'2023-01-20', 480501, N'550       ')
INSERT [dbo].[LichSuGia] ([IDLS], [ThoiGianCapNhat], [MaNganh], [GiaThayDoi]) VALUES (8, N'2023-01-20', 480601, N'550       ')
SET IDENTITY_INSERT [dbo].[LichSuGia] OFF
GO
INSERT [dbo].[LopTinChi] ([MaLopTC], [ID_CTHKNH], [MaPNCLyThuyet], [SoNhomTH], [MaMH]) VALUES (N'ATHT', 6, 6, 1, N'INT1306')
INSERT [dbo].[LopTinChi] ([MaLopTC], [ID_CTHKNH], [MaPNCLyThuyet], [SoNhomTH], [MaMH]) VALUES (N'ATHT02', 6, 15, 2, N'INT1313')
INSERT [dbo].[LopTinChi] ([MaLopTC], [ID_CTHKNH], [MaPNCLyThuyet], [SoNhomTH], [MaMH]) VALUES (N'CNPM', 6, 2, 1, N'INT1340')
INSERT [dbo].[LopTinChi] ([MaLopTC], [ID_CTHKNH], [MaPNCLyThuyet], [SoNhomTH], [MaMH]) VALUES (N'CTDLGT', 5, 6, 1, N'INT1306')
INSERT [dbo].[LopTinChi] ([MaLopTC], [ID_CTHKNH], [MaPNCLyThuyet], [SoNhomTH], [MaMH]) VALUES (N'DLPT', 5, 3, 1, N'INT14148')
INSERT [dbo].[LopTinChi] ([MaLopTC], [ID_CTHKNH], [MaPNCLyThuyet], [SoNhomTH], [MaMH]) VALUES (N'DS1', 4, 12, 1, N'BAS1203')
INSERT [dbo].[LopTinChi] ([MaLopTC], [ID_CTHKNH], [MaPNCLyThuyet], [SoNhomTH], [MaMH]) VALUES (N'GDQP1', 4, 6, 1, N'BAS1105-7')
INSERT [dbo].[LopTinChi] ([MaLopTC], [ID_CTHKNH], [MaPNCLyThuyet], [SoNhomTH], [MaMH]) VALUES (N'GDTC1', 4, 6, 1, N'BAS1106')
INSERT [dbo].[LopTinChi] ([MaLopTC], [ID_CTHKNH], [MaPNCLyThuyet], [SoNhomTH], [MaMH]) VALUES (N'GT1', 4, 7, 1, N'BAS1203')
INSERT [dbo].[LopTinChi] ([MaLopTC], [ID_CTHKNH], [MaPNCLyThuyet], [SoNhomTH], [MaMH]) VALUES (N'HDH', 6, 7, 1, N'INT1319')
INSERT [dbo].[LopTinChi] ([MaLopTC], [ID_CTHKNH], [MaPNCLyThuyet], [SoNhomTH], [MaMH]) VALUES (N'KTMT', 6, 7, 1, N'INT13145')
INSERT [dbo].[LopTinChi] ([MaLopTC], [ID_CTHKNH], [MaPNCLyThuyet], [SoNhomTH], [MaMH]) VALUES (N'LTDT', 6, 7, 1, N'INT1332')
INSERT [dbo].[LopTinChi] ([MaLopTC], [ID_CTHKNH], [MaPNCLyThuyet], [SoNhomTH], [MaMH]) VALUES (N'LTPY', 5, 7, 1, N'INT13162')
INSERT [dbo].[LopTinChi] ([MaLopTC], [ID_CTHKNH], [MaPNCLyThuyet], [SoNhomTH], [MaMH]) VALUES (N'LTW', 6, 4, 1, N'INT1434-3')
INSERT [dbo].[LopTinChi] ([MaLopTC], [ID_CTHKNH], [MaPNCLyThuyet], [SoNhomTH], [MaMH]) VALUES (N'MTT', 5, 7, 1, N'INT1336')
INSERT [dbo].[LopTinChi] ([MaLopTC], [ID_CTHKNH], [MaPNCLyThuyet], [SoNhomTH], [MaMH]) VALUES (N'THCS1', 6, 1, 1, N'INT1154')
INSERT [dbo].[LopTinChi] ([MaLopTC], [ID_CTHKNH], [MaPNCLyThuyet], [SoNhomTH], [MaMH]) VALUES (N'THMAC', 6, 2, 1, N'BAS1150')
INSERT [dbo].[LopTinChi] ([MaLopTC], [ID_CTHKNH], [MaPNCLyThuyet], [SoNhomTH], [MaMH]) VALUES (N'TLVB', 6, 5, 1, N'SKD1103')
INSERT [dbo].[LopTinChi] ([MaLopTC], [ID_CTHKNH], [MaPNCLyThuyet], [SoNhomTH], [MaMH]) VALUES (N'TTCS', 5, 6, 1, N'INT13147')
INSERT [dbo].[LopTinChi] ([MaLopTC], [ID_CTHKNH], [MaPNCLyThuyet], [SoNhomTH], [MaMH]) VALUES (N'TTNT', 4, 7, 1, N'INT1341')
GO
INSERT [dbo].[MonHoc] ([MaMH], [TenMH], [SoTinChi]) VALUES (N'BAS1105-7', N'Giáo dục quốc phòng và an ninh', 3)
INSERT [dbo].[MonHoc] ([MaMH], [TenMH], [SoTinChi]) VALUES (N'BAS1106', N'Giáo dục thể chất 1', 2)
INSERT [dbo].[MonHoc] ([MaMH], [TenMH], [SoTinChi]) VALUES (N'BAS1150', N'Triết học Mác - Lênin', 3)
INSERT [dbo].[MonHoc] ([MaMH], [TenMH], [SoTinChi]) VALUES (N'BAS1152', N'Chủ nghĩa xã hội khoa học', 3)
INSERT [dbo].[MonHoc] ([MaMH], [TenMH], [SoTinChi]) VALUES (N'BAS1201', N'Đại số', 3)
INSERT [dbo].[MonHoc] ([MaMH], [TenMH], [SoTinChi]) VALUES (N'BAS1203', N'Giải tích 1', 3)
INSERT [dbo].[MonHoc] ([MaMH], [TenMH], [SoTinChi]) VALUES (N'BAS1204', N'Giải tích 2', 3)
INSERT [dbo].[MonHoc] ([MaMH], [TenMH], [SoTinChi]) VALUES (N'BAS1226', N'Xác xuất thống kê', 2)
INSERT [dbo].[MonHoc] ([MaMH], [TenMH], [SoTinChi]) VALUES (N'BAS1227', N'Vật lý 3 và thí nghiệm', 3)
INSERT [dbo].[MonHoc] ([MaMH], [TenMH], [SoTinChi]) VALUES (N'INT1154', N'Tin học cơ sở 1', 7)
INSERT [dbo].[MonHoc] ([MaMH], [TenMH], [SoTinChi]) VALUES (N'INT1303', N'An toàn và bảo mật hệ thống thông tin', 3)
INSERT [dbo].[MonHoc] ([MaMH], [TenMH], [SoTinChi]) VALUES (N'INT1306', N'Cấu trúc dữ liệu và giải thuật', 3)
INSERT [dbo].[MonHoc] ([MaMH], [TenMH], [SoTinChi]) VALUES (N'INT1313', N'Cơ sở dữ liệu', 3)
INSERT [dbo].[MonHoc] ([MaMH], [TenMH], [SoTinChi]) VALUES (N'INT13145', N'Kiến trúc máy tính', 3)
INSERT [dbo].[MonHoc] ([MaMH], [TenMH], [SoTinChi]) VALUES (N'INT13147', N'Thực tập cơ sở', 3)
INSERT [dbo].[MonHoc] ([MaMH], [TenMH], [SoTinChi]) VALUES (N'INT13162', N'Lập trình với Python', 3)
INSERT [dbo].[MonHoc] ([MaMH], [TenMH], [SoTinChi]) VALUES (N'INT1319', N'Hệ điều hành', 3)
INSERT [dbo].[MonHoc] ([MaMH], [TenMH], [SoTinChi]) VALUES (N'INT1332', N'Lập trình hướng đối tượng', 3)
INSERT [dbo].[MonHoc] ([MaMH], [TenMH], [SoTinChi]) VALUES (N'INT1336', N'Mạng máy tính', 3)
INSERT [dbo].[MonHoc] ([MaMH], [TenMH], [SoTinChi]) VALUES (N'INT1339', N'Ngôn ngữ lập trình c++', 3)
INSERT [dbo].[MonHoc] ([MaMH], [TenMH], [SoTinChi]) VALUES (N'INT1340', N'Nhập môn công nghệ phần mềm', 3)
INSERT [dbo].[MonHoc] ([MaMH], [TenMH], [SoTinChi]) VALUES (N'INT1341', N'Nhập môn trí tuệ nhân tạo', 3)
INSERT [dbo].[MonHoc] ([MaMH], [TenMH], [SoTinChi]) VALUES (N'INT14148', N'Cơ sở dữ liệu phân tán', 3)
INSERT [dbo].[MonHoc] ([MaMH], [TenMH], [SoTinChi]) VALUES (N'INT1434-3', N'Lập trình Web', 3)
INSERT [dbo].[MonHoc] ([MaMH], [TenMH], [SoTinChi]) VALUES (N'SKD1101', N'Kỹ năng thuyết trình', 1)
INSERT [dbo].[MonHoc] ([MaMH], [TenMH], [SoTinChi]) VALUES (N'SKD1103', N'Kỹ năng tạo lập Văn bản', 1)
GO
SET IDENTITY_INSERT [dbo].[NamHoc] ON 

INSERT [dbo].[NamHoc] ([MaNamHoc], [TenNamHoc]) VALUES (1, N'2019-2020 ')
INSERT [dbo].[NamHoc] ([MaNamHoc], [TenNamHoc]) VALUES (2, N'2020-2021 ')
INSERT [dbo].[NamHoc] ([MaNamHoc], [TenNamHoc]) VALUES (3, N'2021-2022 ')
INSERT [dbo].[NamHoc] ([MaNamHoc], [TenNamHoc]) VALUES (4, N'2022-2023 ')
SET IDENTITY_INSERT [dbo].[NamHoc] OFF
GO
INSERT [dbo].[Nganh] ([MaNganh], [TenNganh], [GiaHienThoi]) VALUES (480101, N'Công nghệ thông tin', N'500       ')
INSERT [dbo].[Nganh] ([MaNganh], [TenNganh], [GiaHienThoi]) VALUES (480201, N'An toàn thông tin', N'500       ')
INSERT [dbo].[Nganh] ([MaNganh], [TenNganh], [GiaHienThoi]) VALUES (480301, N'Công nghệ đa phương tiện', N'500       ')
INSERT [dbo].[Nganh] ([MaNganh], [TenNganh], [GiaHienThoi]) VALUES (480302, N'Công nghệ đa phương tiện - Phát triển ứng dụng', N'500       ')
INSERT [dbo].[Nganh] ([MaNganh], [TenNganh], [GiaHienThoi]) VALUES (480303, N'Công nghệ đa phương tiện - Thiết kế đa phương tiện', N'500       ')
INSERT [dbo].[Nganh] ([MaNganh], [TenNganh], [GiaHienThoi]) VALUES (480401, N'Công nghệ phần mềm', N'500       ')
INSERT [dbo].[Nganh] ([MaNganh], [TenNganh], [GiaHienThoi]) VALUES (480501, N'Kỹ thuật máy tính', N'500       ')
INSERT [dbo].[Nganh] ([MaNganh], [TenNganh], [GiaHienThoi]) VALUES (480601, N'Hệ thống thông tin', N'500       ')
GO
INSERT [dbo].[NhanVienPDT] ([MaNV], [Ho], [TenDem], [Phai], [Ten], [SoDienThoai], [Email], [MaQQ], [NghiLam]) VALUES (N'NV01', N'Le', N'Ngoc', 0, N'Kiet', N'123456789 ', N'kiet@gmail.com', 24, 0)
INSERT [dbo].[NhanVienPDT] ([MaNV], [Ho], [TenDem], [Phai], [Ten], [SoDienThoai], [Email], [MaQQ], [NghiLam]) VALUES (N'NV02', N'Le', N'Tuan', 0, N'Kiet', N'123456789 ', N'tkiet@gmail.com', 24, 0)
GO
SET IDENTITY_INSERT [dbo].[Nhom] ON 

INSERT [dbo].[Nhom] ([MaNhom], [TenNhom]) VALUES (1, N'Nhóm 1')
INSERT [dbo].[Nhom] ([MaNhom], [TenNhom]) VALUES (2, N'Nhóm 2')
INSERT [dbo].[Nhom] ([MaNhom], [TenNhom]) VALUES (3, N'Nhóm 3')
SET IDENTITY_INSERT [dbo].[Nhom] OFF
GO
SET IDENTITY_INSERT [dbo].[Phien] ON 

INSERT [dbo].[Phien] ([MaPhien], [NgayBatDau], [NgayKetThuc], [ID_CTHKNH]) VALUES (1, CAST(N'2019-08-01' AS Date), CAST(N'2019-08-03' AS Date), 1)
INSERT [dbo].[Phien] ([MaPhien], [NgayBatDau], [NgayKetThuc], [ID_CTHKNH]) VALUES (2, CAST(N'2019-12-15' AS Date), CAST(N'2019-12-17' AS Date), 2)
INSERT [dbo].[Phien] ([MaPhien], [NgayBatDau], [NgayKetThuc], [ID_CTHKNH]) VALUES (4, CAST(N'2020-08-01' AS Date), CAST(N'2020-08-03' AS Date), 4)
INSERT [dbo].[Phien] ([MaPhien], [NgayBatDau], [NgayKetThuc], [ID_CTHKNH]) VALUES (5, CAST(N'2021-08-01' AS Date), CAST(N'2021-08-03' AS Date), 5)
INSERT [dbo].[Phien] ([MaPhien], [NgayBatDau], [NgayKetThuc], [ID_CTHKNH]) VALUES (6, CAST(N'2021-12-15' AS Date), CAST(N'2021-12-17' AS Date), 6)
SET IDENTITY_INSERT [dbo].[Phien] OFF
GO
SET IDENTITY_INSERT [dbo].[Phong_Ngay_Ca] ON 

INSERT [dbo].[Phong_Ngay_Ca] ([MaPNC], [TietBatDau], [NgayBatDau], [NgayKetThuc], [Phong], [ThuTrongTuan]) VALUES (1, 7, CAST(N'2023-01-02' AS Date), CAST(N'2023-02-04' AS Date), N'2B34', 2)
INSERT [dbo].[Phong_Ngay_Ca] ([MaPNC], [TietBatDau], [NgayBatDau], [NgayKetThuc], [Phong], [ThuTrongTuan]) VALUES (2, 7, CAST(N'2023-02-13' AS Date), CAST(N'2023-02-19' AS Date), N'2B11', 3)
INSERT [dbo].[Phong_Ngay_Ca] ([MaPNC], [TietBatDau], [NgayBatDau], [NgayKetThuc], [Phong], [ThuTrongTuan]) VALUES (3, 7, CAST(N'2023-02-20' AS Date), CAST(N'2023-02-26' AS Date), N'2B11', 2)
INSERT [dbo].[Phong_Ngay_Ca] ([MaPNC], [TietBatDau], [NgayBatDau], [NgayKetThuc], [Phong], [ThuTrongTuan]) VALUES (4, 1, CAST(N'2023-01-02' AS Date), CAST(N'2023-02-04' AS Date), N'2A25', 2)
INSERT [dbo].[Phong_Ngay_Ca] ([MaPNC], [TietBatDau], [NgayBatDau], [NgayKetThuc], [Phong], [ThuTrongTuan]) VALUES (5, 7, CAST(N'2023-01-02' AS Date), CAST(N'2023-02-04' AS Date), N'2A25', 2)
INSERT [dbo].[Phong_Ngay_Ca] ([MaPNC], [TietBatDau], [NgayBatDau], [NgayKetThuc], [Phong], [ThuTrongTuan]) VALUES (6, 1, CAST(N'2023-01-02' AS Date), CAST(N'2023-02-04' AS Date), N'2A25', 3)
INSERT [dbo].[Phong_Ngay_Ca] ([MaPNC], [TietBatDau], [NgayBatDau], [NgayKetThuc], [Phong], [ThuTrongTuan]) VALUES (7, 7, CAST(N'2023-01-02' AS Date), CAST(N'2023-02-04' AS Date), N'2A25', 3)
INSERT [dbo].[Phong_Ngay_Ca] ([MaPNC], [TietBatDau], [NgayBatDau], [NgayKetThuc], [Phong], [ThuTrongTuan]) VALUES (8, 1, CAST(N'2023-02-13' AS Date), CAST(N'2023-03-05' AS Date), N'2A12', 2)
INSERT [dbo].[Phong_Ngay_Ca] ([MaPNC], [TietBatDau], [NgayBatDau], [NgayKetThuc], [Phong], [ThuTrongTuan]) VALUES (9, 1, CAST(N'2023-01-30' AS Date), CAST(N'2023-02-12' AS Date), N'2B11', 6)
INSERT [dbo].[Phong_Ngay_Ca] ([MaPNC], [TietBatDau], [NgayBatDau], [NgayKetThuc], [Phong], [ThuTrongTuan]) VALUES (10, 1, CAST(N'2023-02-13' AS Date), CAST(N'2023-02-26' AS Date), N'2B11', 6)
INSERT [dbo].[Phong_Ngay_Ca] ([MaPNC], [TietBatDau], [NgayBatDau], [NgayKetThuc], [Phong], [ThuTrongTuan]) VALUES (11, 1, CAST(N'2023-02-27' AS Date), CAST(N'2023-03-12' AS Date), N'2B12', 6)
INSERT [dbo].[Phong_Ngay_Ca] ([MaPNC], [TietBatDau], [NgayBatDau], [NgayKetThuc], [Phong], [ThuTrongTuan]) VALUES (12, 2, CAST(N'2023-03-25' AS Date), CAST(N'2023-06-01' AS Date), N'2B11', 2)
INSERT [dbo].[Phong_Ngay_Ca] ([MaPNC], [TietBatDau], [NgayBatDau], [NgayKetThuc], [Phong], [ThuTrongTuan]) VALUES (13, 7, CAST(N'2023-01-02' AS Date), CAST(N'2023-02-04' AS Date), N'2B34', 3)
INSERT [dbo].[Phong_Ngay_Ca] ([MaPNC], [TietBatDau], [NgayBatDau], [NgayKetThuc], [Phong], [ThuTrongTuan]) VALUES (14, 1, CAST(N'2023-01-02' AS Date), CAST(N'2023-02-04' AS Date), N'2A11', 6)
INSERT [dbo].[Phong_Ngay_Ca] ([MaPNC], [TietBatDau], [NgayBatDau], [NgayKetThuc], [Phong], [ThuTrongTuan]) VALUES (15, 1, CAST(N'2023-01-02' AS Date), CAST(N'2023-02-04' AS Date), N'2A25', 4)
INSERT [dbo].[Phong_Ngay_Ca] ([MaPNC], [TietBatDau], [NgayBatDau], [NgayKetThuc], [Phong], [ThuTrongTuan]) VALUES (16, 2, CAST(N'2023-01-02' AS Date), CAST(N'2023-02-04' AS Date), N'2A11', 4)
SET IDENTITY_INSERT [dbo].[Phong_Ngay_Ca] OFF
GO
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (24, N'Hà Nội')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (28, N'Hồ Chí Minh')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (203, N'Quảng Ninh')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (204, N'Bắc Giang')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (205, N'Lạng Sơn')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (206, N'Cao Bằng')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (207, N'Tuyên Quang')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (208, N'Thái Nguyên')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (209, N'Bắc Cạn')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (212, N'Sơn La')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (213, N'Lai Châu')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (214, N'Lào Cai')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (215, N'Điện Biên')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (216, N'Yên Bái')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (220, N'Hải Dương')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (221, N'Hưng Yên')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (222, N'Bắc Ninh')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (225, N'Hải Phòng')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (226, N'Hà Nam')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (227, N'Thái Bình')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (228, N'Nam Định')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (229, N'Ninh Bình')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (232, N'Quảng Bình')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (233, N'Quảng Trị')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (234, N'Thừa Thiên - Huế')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (235, N'Quảng Nam')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (236, N'Đà Nẵng')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (237, N'Thanh Hóa')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (238, N'Nghệ An')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (239, N'Hà Tĩnh')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (251, N'Đồng Nai')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (252, N'Bình Thuận')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (254, N'Bà Rịa - Vũng  Tàu')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (255, N'Quảng Ngãi')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (256, N'Bình Định')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (257, N'Phú Yên')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (258, N'Khánh Hòa')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (259, N'Ninh Thuận')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (260, N'Kon Tum')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (261, N'Đắk Nông')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (262, N'Đắk Lắk')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (263, N'Lâm Đồng')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (269, N'Gia Lai')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (270, N'Vĩnh Long')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (271, N'Bình Phước')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (272, N'Long An')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (273, N'Tiền Giang')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (274, N'Bình Dương')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (275, N'Bến Tre')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (276, N'Tây Ninh')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (277, N'Đồng Tháp')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (290, N'Cà Mau')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (291, N'Bạc Liêu')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (292, N'Cần Thơ')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (293, N'Hậu Giang')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (294, N'Trà Vinh')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (296, N'An Giang')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (297, N'Kiên Giang')
INSERT [dbo].[QueQuan] ([MaQQ], [TenQQ]) VALUES (299, N'Sóc Trăng')
GO
INSERT [dbo].[SinhVien] ([MaSV], [Ho], [TenDem], [Ten], [Phai], [NgaySinh], [LopKhoaHoc], [ChuongTrinhDaoTao], [SoDienThoai_1], [SoDienThoai_2], [Email_1], [Email_2], [NghiHoc], [MaNganh], [MaQQ]) VALUES (N'N20DCCN007', N'Phạm ', N'Khánh', N'Băng', 1, CAST(N'2002-08-09' AS Date), N'D20CQCN01-N', N'Chính Quy', N'0865486437', N'0123456789', N'n20dccn007@ptithcm.student.edu.vn', N'bangpham@gmail.com', 0, 480101, 290)
INSERT [dbo].[SinhVien] ([MaSV], [Ho], [TenDem], [Ten], [Phai], [NgaySinh], [LopKhoaHoc], [ChuongTrinhDaoTao], [SoDienThoai_1], [SoDienThoai_2], [Email_1], [Email_2], [NghiHoc], [MaNganh], [MaQQ]) VALUES (N'N20DCCN012', N'Đoàn', N'Long', N'Âu', 1, CAST(N'2002-12-20' AS Date), N'D20CQCN01-N', N'Chính Quy', N'0121234321', NULL, N'n20dccn012@ptithcm.student.edu.vn', NULL, 0, 480101, 232)
INSERT [dbo].[SinhVien] ([MaSV], [Ho], [TenDem], [Ten], [Phai], [NgaySinh], [LopKhoaHoc], [ChuongTrinhDaoTao], [SoDienThoai_1], [SoDienThoai_2], [Email_1], [Email_2], [NghiHoc], [MaNganh], [MaQQ]) VALUES (N'N20DCCN027', N'Đoàn ', N'Trung', N'Kiên', 1, CAST(N'2001-07-27' AS Date), N'D20CQCN01-N', N'Chính Quy', N'0869145877', N'1234567890', N'n20dccn027@student.ptithcm.edu.vn', N'trkiendzaii@gmail.com', 0, 480201, 222)
INSERT [dbo].[SinhVien] ([MaSV], [Ho], [TenDem], [Ten], [Phai], [NgaySinh], [LopKhoaHoc], [ChuongTrinhDaoTao], [SoDienThoai_1], [SoDienThoai_2], [Email_1], [Email_2], [NghiHoc], [MaNganh], [MaQQ]) VALUES (N'N20DCCN028', N'LE', N'Ngọc Tuấn', N'Kiệt', 1, CAST(N'2002-05-22' AS Date), N'D20CQCN01-N', N'Chính Quy', N'123456789', NULL, N'n20dccn028', NULL, 0, 480201, 222)
INSERT [dbo].[SinhVien] ([MaSV], [Ho], [TenDem], [Ten], [Phai], [NgaySinh], [LopKhoaHoc], [ChuongTrinhDaoTao], [SoDienThoai_1], [SoDienThoai_2], [Email_1], [Email_2], [NghiHoc], [MaNganh], [MaQQ]) VALUES (N'N20DCCN080', N'Nguyễn', N'Quang', N'Trung', 1, CAST(N'2002-01-20' AS Date), N'D20CQCN01-N', N'Chính Quy', N'0912496112', NULL, N'n20dccn080@ptithcm.student.edu.vn', NULL, 0, 480201, 232)
GO
INSERT [dbo].[TaiKhoan] ([TaiKhoan], [MatKhau], [TrangThai], [MaChucVu]) VALUES (N'N20DCCN007', N'bang', 0, N'SV')
INSERT [dbo].[TaiKhoan] ([TaiKhoan], [MatKhau], [TrangThai], [MaChucVu]) VALUES (N'N20DCCN012', N'1', 0, N'SV')
INSERT [dbo].[TaiKhoan] ([TaiKhoan], [MatKhau], [TrangThai], [MaChucVu]) VALUES (N'N20DCCN027', N'2707', 0, N'SV')
INSERT [dbo].[TaiKhoan] ([TaiKhoan], [MatKhau], [TrangThai], [MaChucVu]) VALUES (N'N20DCCN028', N'1', 0, N'SV')
INSERT [dbo].[TaiKhoan] ([TaiKhoan], [MatKhau], [TrangThai], [MaChucVu]) VALUES (N'N20DCCN080', N'1', 0, N'SV')
INSERT [dbo].[TaiKhoan] ([TaiKhoan], [MatKhau], [TrangThai], [MaChucVu]) VALUES (N'NV01', N'1', 0, N'NV')
INSERT [dbo].[TaiKhoan] ([TaiKhoan], [MatKhau], [TrangThai], [MaChucVu]) VALUES (N'NV02', N'1', 0, N'NV')
GO
/****** Object:  Index [UK_HK_NH]    Script Date: 3/13/2023 9:27:37 PM ******/
ALTER TABLE [dbo].[CT_HocKy_NamHoc] ADD  CONSTRAINT [UK_HK_NH] UNIQUE NONCLUSTERED 
(
	[MaHocKy] ASC,
	[MaNamHoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UK_CT_Nhom]    Script Date: 3/13/2023 9:27:37 PM ******/
ALTER TABLE [dbo].[CT_Nhom] ADD  CONSTRAINT [UK_CT_Nhom] UNIQUE NONCLUSTERED 
(
	[MaNhom] ASC,
	[MaLopTC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UK_TNPT]    Script Date: 3/13/2023 9:27:37 PM ******/
ALTER TABLE [dbo].[Phong_Ngay_Ca] ADD  CONSTRAINT [UK_TNPT] UNIQUE NONCLUSTERED 
(
	[TietBatDau] ASC,
	[NgayBatDau] ASC,
	[Phong] ASC,
	[ThuTrongTuan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[CT_Nhom] ADD  CONSTRAINT [DF_CT_Nhom_SoLuongDaDK]  DEFAULT ((0)) FOR [SoLuongDaDK]
GO
ALTER TABLE [dbo].[GiangVien] ADD  CONSTRAINT [DF_GiangVien_Phai]  DEFAULT ((0)) FOR [Phai]
GO
ALTER TABLE [dbo].[NhanVienPDT] ADD  CONSTRAINT [DF_NhanVienPDT_Phai]  DEFAULT ((0)) FOR [Phai]
GO
ALTER TABLE [dbo].[NhanVienPDT] ADD  CONSTRAINT [DF_NhanVienPDT_NghiLam]  DEFAULT ((0)) FOR [NghiLam]
GO
ALTER TABLE [dbo].[SinhVien] ADD  CONSTRAINT [DF_SinhVien_Phai]  DEFAULT ((0)) FOR [Phai]
GO
ALTER TABLE [dbo].[SinhVien] ADD  CONSTRAINT [DF__SinhVien__NghiHo__3F466844]  DEFAULT ('0') FOR [NghiHoc]
GO
ALTER TABLE [dbo].[CT_HocKy_NamHoc]  WITH CHECK ADD  CONSTRAINT [FK_CT_HocKy_NamHoc_HocKy] FOREIGN KEY([MaHocKy])
REFERENCES [dbo].[HocKy] ([MaHocKy])
GO
ALTER TABLE [dbo].[CT_HocKy_NamHoc] CHECK CONSTRAINT [FK_CT_HocKy_NamHoc_HocKy]
GO
ALTER TABLE [dbo].[CT_HocKy_NamHoc]  WITH CHECK ADD  CONSTRAINT [FK_CT_HocKy_NamHoc_NamHoc] FOREIGN KEY([MaNamHoc])
REFERENCES [dbo].[NamHoc] ([MaNamHoc])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[CT_HocKy_NamHoc] CHECK CONSTRAINT [FK_CT_HocKy_NamHoc_NamHoc]
GO
ALTER TABLE [dbo].[CT_Nhom]  WITH CHECK ADD  CONSTRAINT [FK_CT_Nhom_LopTinChi] FOREIGN KEY([MaLopTC])
REFERENCES [dbo].[LopTinChi] ([MaLopTC])
GO
ALTER TABLE [dbo].[CT_Nhom] CHECK CONSTRAINT [FK_CT_Nhom_LopTinChi]
GO
ALTER TABLE [dbo].[CT_Nhom]  WITH CHECK ADD  CONSTRAINT [FK_CT_Nhom_Nhom] FOREIGN KEY([MaNhom])
REFERENCES [dbo].[Nhom] ([MaNhom])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[CT_Nhom] CHECK CONSTRAINT [FK_CT_Nhom_Nhom]
GO
ALTER TABLE [dbo].[CT_Nhom]  WITH CHECK ADD  CONSTRAINT [FK_CT_Nhom_Phong_Ngay_Ca] FOREIGN KEY([MaPNCThucHanh])
REFERENCES [dbo].[Phong_Ngay_Ca] ([MaPNC])
GO
ALTER TABLE [dbo].[CT_Nhom] CHECK CONSTRAINT [FK_CT_Nhom_Phong_Ngay_Ca]
GO
ALTER TABLE [dbo].[DangKy]  WITH CHECK ADD  CONSTRAINT [FK_DangKy_CT_Nhom] FOREIGN KEY([IDCTN])
REFERENCES [dbo].[CT_Nhom] ([IDCTN])
GO
ALTER TABLE [dbo].[DangKy] CHECK CONSTRAINT [FK_DangKy_CT_Nhom]
GO
ALTER TABLE [dbo].[DangKy]  WITH CHECK ADD  CONSTRAINT [FK_DangKy_SinhVien] FOREIGN KEY([MaSV])
REFERENCES [dbo].[SinhVien] ([MaSV])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[DangKy] CHECK CONSTRAINT [FK_DangKy_SinhVien]
GO
ALTER TABLE [dbo].[DayLop]  WITH CHECK ADD  CONSTRAINT [FK_DayLop_GV] FOREIGN KEY([MaGV])
REFERENCES [dbo].[GiangVien] ([MaGV])
GO
ALTER TABLE [dbo].[DayLop] CHECK CONSTRAINT [FK_DayLop_GV]
GO
ALTER TABLE [dbo].[DayLop]  WITH CHECK ADD  CONSTRAINT [FK_DayLop_LopTC] FOREIGN KEY([MaLopTC])
REFERENCES [dbo].[LopTinChi] ([MaLopTC])
GO
ALTER TABLE [dbo].[DayLop] CHECK CONSTRAINT [FK_DayLop_LopTC]
GO
ALTER TABLE [dbo].[GiangVien]  WITH CHECK ADD  CONSTRAINT [FK_GiangVien_HocVi] FOREIGN KEY([MaHocVi])
REFERENCES [dbo].[HocVi] ([MaHocVi])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[GiangVien] CHECK CONSTRAINT [FK_GiangVien_HocVi]
GO
ALTER TABLE [dbo].[GiangVien]  WITH CHECK ADD  CONSTRAINT [FK_GiangVien_QueQuan] FOREIGN KEY([MaQQ])
REFERENCES [dbo].[QueQuan] ([MaQQ])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[GiangVien] CHECK CONSTRAINT [FK_GiangVien_QueQuan]
GO
ALTER TABLE [dbo].[LichSuGia]  WITH CHECK ADD  CONSTRAINT [FK_LichSuGia_Nganh] FOREIGN KEY([MaNganh])
REFERENCES [dbo].[Nganh] ([MaNganh])
GO
ALTER TABLE [dbo].[LichSuGia] CHECK CONSTRAINT [FK_LichSuGia_Nganh]
GO
ALTER TABLE [dbo].[LopTinChi]  WITH CHECK ADD  CONSTRAINT [FK_LopTinChi_CT_HocKy_NamHoc] FOREIGN KEY([ID_CTHKNH])
REFERENCES [dbo].[CT_HocKy_NamHoc] ([ID_CTHKNH])
GO
ALTER TABLE [dbo].[LopTinChi] CHECK CONSTRAINT [FK_LopTinChi_CT_HocKy_NamHoc]
GO
ALTER TABLE [dbo].[LopTinChi]  WITH CHECK ADD  CONSTRAINT [FK_LopTinChi_MonHoc] FOREIGN KEY([MaMH])
REFERENCES [dbo].[MonHoc] ([MaMH])
GO
ALTER TABLE [dbo].[LopTinChi] CHECK CONSTRAINT [FK_LopTinChi_MonHoc]
GO
ALTER TABLE [dbo].[LopTinChi]  WITH CHECK ADD  CONSTRAINT [FK_LopTinChi_Phong_Ngay_Ca] FOREIGN KEY([MaPNCLyThuyet])
REFERENCES [dbo].[Phong_Ngay_Ca] ([MaPNC])
GO
ALTER TABLE [dbo].[LopTinChi] CHECK CONSTRAINT [FK_LopTinChi_Phong_Ngay_Ca]
GO
ALTER TABLE [dbo].[NhanVienPDT]  WITH CHECK ADD  CONSTRAINT [FK_NhanVienPDT_QueQuan] FOREIGN KEY([MaQQ])
REFERENCES [dbo].[QueQuan] ([MaQQ])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[NhanVienPDT] CHECK CONSTRAINT [FK_NhanVienPDT_QueQuan]
GO
ALTER TABLE [dbo].[NhanVienPDT]  WITH CHECK ADD  CONSTRAINT [FK_NhanVienPDT_TaiKhoan] FOREIGN KEY([MaNV])
REFERENCES [dbo].[TaiKhoan] ([TaiKhoan])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[NhanVienPDT] CHECK CONSTRAINT [FK_NhanVienPDT_TaiKhoan]
GO
ALTER TABLE [dbo].[Phien]  WITH CHECK ADD  CONSTRAINT [FK_Phien_CT_HocKy_NamHoc] FOREIGN KEY([ID_CTHKNH])
REFERENCES [dbo].[CT_HocKy_NamHoc] ([ID_CTHKNH])
GO
ALTER TABLE [dbo].[Phien] CHECK CONSTRAINT [FK_Phien_CT_HocKy_NamHoc]
GO
ALTER TABLE [dbo].[SinhVien]  WITH CHECK ADD  CONSTRAINT [FK_SinhVien_Nganh] FOREIGN KEY([MaNganh])
REFERENCES [dbo].[Nganh] ([MaNganh])
GO
ALTER TABLE [dbo].[SinhVien] CHECK CONSTRAINT [FK_SinhVien_Nganh]
GO
ALTER TABLE [dbo].[SinhVien]  WITH CHECK ADD  CONSTRAINT [FK_SinhVien_QueQuan] FOREIGN KEY([MaQQ])
REFERENCES [dbo].[QueQuan] ([MaQQ])
GO
ALTER TABLE [dbo].[SinhVien] CHECK CONSTRAINT [FK_SinhVien_QueQuan]
GO
ALTER TABLE [dbo].[SinhVien]  WITH CHECK ADD  CONSTRAINT [FK_SinhVien_TaiKhoan] FOREIGN KEY([MaSV])
REFERENCES [dbo].[TaiKhoan] ([TaiKhoan])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[SinhVien] CHECK CONSTRAINT [FK_SinhVien_TaiKhoan]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_ChucVu] FOREIGN KEY([MaChucVu])
REFERENCES [dbo].[ChucVu] ([MaChucVu])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_TaiKhoan_ChucVu]
GO
/****** Object:  StoredProcedure [dbo].[CheckTaiKhoan]    Script Date: 3/13/2023 9:27:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[CheckTaiKhoan]
@taiKhoan nvarchar(20),
@matKhau nvarchar(50)
AS
BEGIN

	SELECT MaChucVu, TrangThai
	FROM
	(SELECT * 
	FROM TaiKhoan
	WHERE TaiKhoan.TaiKhoan = @taiKhoan AND BINARY_CHECKSUM(TaiKhoan.MatKhau) = BINARY_CHECKSUM(@matKhau)
	) AS TK
	GROUP BY MaChucVu, TrangThai
END
GO
/****** Object:  StoredProcedure [dbo].[DelGVByID]    Script Date: 3/13/2023 9:27:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[DelGVByID] @MaGV nvarchar(30)  
AS  
BEGIN  
DELETE FROM GiangVien WHERE MaGV = @MaGV  
END
GO
/****** Object:  StoredProcedure [dbo].[DelLTCByID]    Script Date: 3/13/2023 9:27:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[DelLTCByID] @MaLTC nvarchar(20)  
AS  
BEGIN  

DECLARE @IDCTN INT = (SELECT IDCTN FROM CT_Nhom WHERE MaLopTC = @MaLTC)
DELETE FROM DangKy WHERE DangKy.IDCTN = @IDCTN
DELETE FROM CT_Nhom WHERE MaLopTC = @MaLTC
DELETE FROM DayLop WHERE MaLopTC = @MaLTC
DELETE FROM LopTinChi WHERE MaLopTC = @MaLTC  
END
GO
/****** Object:  StoredProcedure [dbo].[DelMHByID]    Script Date: 3/13/2023 9:27:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[DelMHByID] @MaMH nvarchar(20)  
AS  
BEGIN  
DELETE FROM MonHoc WHERE MaMH = @MaMH  
END
GO
/****** Object:  StoredProcedure [dbo].[DelSVByID]    Script Date: 3/13/2023 9:27:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[DelSVByID] @MaSV nvarchar(20)  
AS  
BEGIN  
DELETE FROM SinhVien WHERE MaSV = @MaSV  
END
GO
/****** Object:  StoredProcedure [dbo].[DSLOP]    Script Date: 3/13/2023 9:27:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[DSLOP]
@IDCTHKNH INT
AS
BEGIN

	DECLARE @GiaTicChi INT = (SELECT GiaTien FROM (SELECT IDGTC, GiaTien FROM GiaTinChi) AS GTC INNER JOIN (SELECT IDGTC FROM CT_HocKy_NamHoc WHERE ID_CTHKNH = @IDCTHKNH)  AS HK ON GTC.IDGTC = HK.IDGTC) 
	
	SELECT MonHoc.MaMH, TenMH, SoTinChi, GiaTien = @GiaTicChi, 
			TBDLT = PNCLT.TietBatDau, MaNhom, SoLuongTD, SoLuongDaDK, ThuLT = PNCLT.ThuTrongTuan, PLT = PNCLT.Phong, NBDLT = PNCLT.NgayBatDau, NKTLT = PNCLT.NgayKetThuc,
				TBDTH = PNCTH.TietBatDau, ThuTH = PNCTH.ThuTrongTuan,PTH =  PNCTH.Phong,NBDTH = PNCTH.NgayBatDau, NKTTH = PNCTH.NgayKetThuc
                FROM LopTinChi 
                LEFT JOIN MonHoc ON LopTinChi.MaMH = MonHoc.MaMH 
                LEFT JOIN Phong_Ngay_Ca AS PNCLT ON MaPNCLyThuyet = PNCLT.MaPNC
                --LEFT JOIN CT_HocKy_NamHoc ON LopTinChi.ID_CTHKNH = CT_HocKy_NamHoc.ID_CTHKNH 
               -- LEFT JOIN NamHoc ON CT_HocKy_NamHoc.MaNamHoc = NamHoc.MaNamHoc 
                --LEFT JOIN HocKy ON CT_HocKy_NamHoc.MaHocKy = HocKy.MaHocKy
				RIGHT JOIN CT_Nhom ON CT_Nhom.MaLopTC = LopTinChi.MaLopTC
				LEFT JOIN Phong_Ngay_Ca AS PNCTH ON CT_Nhom.MaPNCThucHanh = PNCTH.MaPNC
				WHERE LopTinChi.ID_CTHKNH = @IDCTHKNH
	

END
GO
/****** Object:  StoredProcedure [dbo].[DSLOPSVDK]    Script Date: 3/13/2023 9:27:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[DSLOPSVDK]
@maSV nvarchar(20),
@IDCTHKNH int
AS
BEGIN

	DECLARE @GiaTicChi INT = (SELECT GiaTien FROM (SELECT IDGTC, GiaTien FROM GiaTinChi) AS GTC INNER JOIN (SELECT IDGTC FROM CT_HocKy_NamHoc WHERE ID_CTHKNH = @IDCTHKNH)  AS HK ON GTC.IDGTC = HK.IDGTC) 

	SELECT MonHoc.MaMH, TenMH, SoTinChi, GiaTien = @GiaTicChi, 
		   TBDLT = PNCLT.TietBatDau, MaNhom, SoLuongTD, SoLuongDaDK, ThuLT = PNCLT.ThuTrongTuan, PLT = PNCLT.Phong, NBDLT = PNCLT.NgayBatDau, NKTLT = PNCLT.NgayKetThuc,
		   TBDTH = PNCTH.TietBatDau, ThuTH = PNCTH.ThuTrongTuan,PTH =  PNCTH.Phong,NBDTH = PNCTH.NgayBatDau, NKTTH = PNCTH.NgayKetThuc
    FROM LopTinChi 
		 
         LEFT JOIN MonHoc ON LopTinChi.MaMH = MonHoc.MaMH 
         LEFT JOIN Phong_Ngay_Ca AS PNCLT ON MaPNCLyThuyet = PNCLT.MaPNC
                --LEFT JOIN CT_HocKy_NamHoc ON LopTinChi.ID_CTHKNH = CT_HocKy_NamHoc.ID_CTHKNH 
               -- LEFT JOIN NamHoc ON CT_HocKy_NamHoc.MaNamHoc = NamHoc.MaNamHoc 
                --LEFT JOIN HocKy ON CT_HocKy_NamHoc.MaHocKy = HocKy.MaHocKy
		 RIGHT JOIN CT_Nhom ON CT_Nhom.MaLopTC = LopTinChi.MaLopTC
		 LEFT JOIN Phong_Ngay_Ca AS PNCTH ON CT_Nhom.MaPNCThucHanh = PNCTH.MaPNC
		 INNER JOIN	DangKy ON DangKy.IDCTN = CT_Nhom.IDCTN
		 WHERE LopTinChi.ID_CTHKNH = @IDCTHKNH AND DangKy.MaSV = @maSV

END
GO
/****** Object:  StoredProcedure [dbo].[GetThongTin]    Script Date: 3/13/2023 9:27:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[GetThongTin]
@maSV nvarchar(20)
AS
BEGIN
	SELECT Ho, TenDem, Ten FROM SinhVien WHERE MaSV = @maSV
END
GO
/****** Object:  StoredProcedure [dbo].[InsertToLopTinChi]    Script Date: 3/13/2023 9:27:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[InsertToLopTinChi] @MaLopTC nvarchar(20), @MaMH nvarchar(20), @HocKy nvarchar(15), @NamHoc nchar(10),
@TietBatDau INT, @Thu INT, @Phong nvarchar(10), @NgayBatDau DATE, @NgayKetThuc DATE, @SoNhomTH INT, @MaGV1 nvarchar(20), @MaGV2 nvarchar(20)
AS 
BEGIN
	DECLARE @MaPNCLT INT 
	EXEC @MaPNCLT= MergePhongNgayCa @TietBatDau = @TietBatDau, @NgayBatDau = @NgayBatDau, @NgayKetThuc = @NgayKetThuc, @Phong = @Phong, @ThuTrongTuan = @Thu
	DECLARE @Ma_CT_HKNH INT = (
	SELECT ID_CTHKNH FROM CT_HocKy_NamHoc
						RIGHT JOIN (SELECT MaNamHoc FROM NamHoc WHERE TenNamHoc = @NamHoc) AS NH ON CT_HocKy_NamHoc.MaNamHoc = NH.MaNamHoc
						RIGHT JOIN (SELECT * FROM HocKy WHERE TenHocKy = @HocKy) AS HK ON CT_HocKy_NamHoc.MaHocKy = HK.MaHocKy
	)
	INSERT INTO LopTinChi(MaLopTC, MaMH, ID_CTHKNH, MaPNCLyThuyet, SoNhomTH) VALUES (@MaLopTC, @MaMH, @Ma_CT_HKNH, @MaPNCLT, @SoNhomTH)
	INSERT INTO DayLop(MaLopTC, MaGV) VALUES (@MaLopTC, @MaGV1)

	MERGE INTO Daylop AS TARGET
	USING (SELECT MaLTC = @MaLopTC, MaGV2 = @MaGV2) AS SOURCE
	ON (TARGET.MaLopTC = SOURCE.MaLTC and TARGET.MaGV = SOURCE.MaGV2)
	WHEN NOT MATCHED THEN
	INSERT (MaLopTC, MaGV) VALUES (@MaLopTC, SOURCE.MaGV2);
END
GO
/****** Object:  StoredProcedure [dbo].[LuuLopSVDK]    Script Date: 3/13/2023 9:27:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[LuuLopSVDK]
@maSV nvarchar(20),
@maMH nvarchar(20),
@mnhom int,
@tietBD int,
@ThuTrongTuan int,
@ngayBD nvarchar(10),
@phong nvarchar(10),
@ID_CTHKNH int

AS
BEGIN
	
	DECLARE @MaPNC INT = (SELECT MaPNC FROM Phong_Ngay_Ca WHERE TietBatDau = @tietBD AND ThuTrongTuan = @ThuTrongTuan 
																AND NgayBatDau = @ngayBD AND Phong = @phong)

	DECLARE @malop  nvarchar(20) = (SELECT MaLopTC FROM LopTinChi WHERE MaPNCLyThuyet = @MaPNC AND ID_CTHKNH = @ID_CTHKNH)

	DECLARE @IDCTN INT = (SELECT IDCTN FROM CT_Nhom  WHERE MaLopTC = @malop AND MaNhom = @mnhom)

	--SELECT MALOP = @maLop

	Begin
	MERGE INTO DangKy AS target
	USING (
		SELECT @maSV AS maSV, @IDCTN AS IDCTN
	) AS source
	
	ON target.MaSV = source.maSV AND target.IDCTN = source.IDCTN
	
	WHEN MATCHED THEN
		UPDATE SET target.MaSV = source.maSV, target.IDCTN = source.IDCTN
	
	WHEN NOT MATCHED THEN
		INSERT (MaSV, IDCTN) VALUES (source.maSV, source.IDCTN);
		

	end;	
	UPDATE CT_Nhom SET SoLuongDaDK = (SELECT count(*) from DangKy WHERE IDCTN = @IDCTN);


	
		
END
GO
/****** Object:  StoredProcedure [dbo].[MergeGiaTinChi]    Script Date: 3/13/2023 9:27:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[MergeGiaTinChi] @GiaTien money
AS BEGIN
CREATE table #Temp
(
    GiaTien MONEY
) 
INSERT INTO #Temp(GiaTien) VALUES (@GiaTien)

MERGE INTO GiaTinChi AS TARGET
USING #Temp AS SOURCE
ON TARGET.GiaTien = SOURCE.GiaTien
WHEN NOT MATCHED THEN
INSERT (GiaTien) VALUES (SOURCE.GiaTien);

DROP TABLE #Temp

DECLARE @IDGTC INT = (SELECT IDGTC FROM GiaTinChi WHERE GiaTien = @GiaTien) 
RETURN @IDGTC
END
GO
/****** Object:  StoredProcedure [dbo].[MergePhongNgayCa]    Script Date: 3/13/2023 9:27:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[MergePhongNgayCa] @TietBatDau INT, @NgayBatDau DATE, @NgayKetThuc DATE, @Phong NVARCHAR(10), @ThuTrongTuan INT
AS BEGIN

CREATE table #Temp
(
    TietBatDau INT, NgayBatDau DATE, NgayKetThuc DATE, Phong NVARCHAR(10), ThuTrongTuan INT
) 
INSERT INTO #Temp(TietBatDau, NgayBatDau, NgayKetThuc, Phong, ThuTrongTuan) VALUES (@TietBatDau, @NgayBatDau, @NgayKetThuc, @Phong, @ThuTrongTuan)

MERGE INTO Phong_Ngay_Ca AS TARGET
USING #Temp AS SOURCE
ON TARGET.TietBatDau = SOURCE.TietBatDau AND TARGET.NgayBatDau = SOURCE.NgayBatDau AND TARGET.NgayKetThuc = SOURCE.NgayKetThuc AND
TARGET.Phong = SOURCE.Phong AND TARGET.ThuTrongTuan = SOURCE.ThuTrongTuan
WHEN NOT MATCHED
THEN INSERT (TietBatDau, NgayBatDau, NgayKetThuc, Phong, ThuTrongTuan)
VALUES (SOURCE.TietBatDau, SOURCE.NgayBatDau, SOURCE.NgayKetThuc, SOURCE.Phong, SOURCE.ThuTrongTuan);

DROP TABLE #Temp

DECLARE @maPNC INT = (SELECT MaPNC 
FROM Phong_Ngay_Ca
WHERE TietBatDau = @TietBatDau and NgayBatDau = @NgayBatDau and NgayKetThuc = @NgayKetThuc and Phong = @Phong and ThuTrongTuan = @ThuTrongTuan)
RETURN @maPNC
END
GO
/****** Object:  StoredProcedure [dbo].[SelectGVByID]    Script Date: 3/13/2023 9:27:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[SelectGVByID] @MaGV nvarchar(30)  
AS  
BEGIN  
SELECT MaGV, Ho, Ten, Tendem, NgaySinh, SoDienThoai_1, SoDienThoai_2, Email_1, Email_2, NghiLam, MaQQ, GhiChu, MaHocVi   
FROM GiangVien AS GV  
WHERE MaGV = @MaGV  
END
GO
/****** Object:  StoredProcedure [dbo].[SelectMHByID]    Script Date: 3/13/2023 9:27:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[SelectMHByID] @MaMH nvarchar(20)  
AS  
BEGIN  
SELECT MaMH, TenMH, SoTinChi  
FROM MonHoc AS MH
WHERE MaMH = @MaMH  
END
GO
/****** Object:  StoredProcedure [dbo].[SelectSVByID]    Script Date: 3/13/2023 9:27:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[SelectSVByID] @MaSV nvarchar(20)  
AS  
BEGIN  
SELECT MaSV, Ho, TenDem, Ten, Phai, NgaySinh, LopKhoaHoc, ChuongTrinhDaoTao, SoDienThoai_1, SoDienThoai_2, Email_1, Email_2, NghiHoc, MaNganh, MaQQ   
FROM SinhVien AS SV  
WHERE MaSV = @MaSV  
END
GO
/****** Object:  StoredProcedure [dbo].[SuaSinhVien]    Script Date: 3/13/2023 9:27:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SuaSinhVien]
@maSV nvarchar(20), @sdt nvarchar(50), @email nvarchar(50)
AS
BEGIN

	UPDATE SinhVien
	SET SoDienThoai_2 = @sdt, Email_2 = @email
	WHERE MaSV = @maSV
END
GO
/****** Object:  StoredProcedure [dbo].[ThayDoiMatKhau]    Script Date: 3/13/2023 9:27:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[ThayDoiMatKhau]
@taiKhoan nvarchar(20),
@matKhau nvarchar(50),
@matKhauMoi nvarchar(50),
@EXISTS INT OUTPUT
AS
BEGIN 
	SET @EXISTS  = (SELECT COUNT(*) FROM TaiKhoan WHERE TaiKhoan = @taiKhoan AND BINARY_CHECKSUM(MatKhau) =  BINARY_CHECKSUM(@matKhau))
	IF @EXISTS > 0
		UPDATE TaiKhoan SET MatKhau = @matKhauMoi WHERE TaiKhoan = @TaiKhoan

END
GO
/****** Object:  StoredProcedure [dbo].[ThemCTNhom]    Script Date: 3/13/2023 9:27:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[ThemCTNhom]
@maNhom int, @maLopTC NVARCHAR(20), @slgToiDa INT, @tietBatDau INT, @ngayBatDau DATE, @ngayKetThuc Date, @phong NVARCHAR(10), @thu INT
AS BEGIN
DECLARE @maPNCTH INT 
EXEC @maPNCTH = MergePhongNgayCa @TietBatDau = @tietBatDau, @NgayBatDau = @ngayBatDau, @NgayKetThuc = @ngayKetThuc, @Phong = @phong, @ThuTrongTuan = @thu

INSERT INTO CT_Nhom(MaNhom, MaLopTC, SoLuongTD, SoLuongDaDK, MaPNCThucHanh) VALUES (@maNhom, @maLopTC, @slgToiDa, 0, @maPNCTH)

END
GO
/****** Object:  StoredProcedure [dbo].[UpadteLopTinChi]    Script Date: 3/13/2023 9:27:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UpadteLopTinChi] @MaLopTC nvarchar(20), @MaMH nvarchar(20), @HocKy nvarchar(15), @NamHoc nchar(10),
@TietBatDau INT, @Thu INT, @Phong nvarchar(10), @NgayBatDau DATE, @NgayKetThuc DATE, @SoNhomTH INT, @MaGV1 nvarchar(20), @MaGV2 nvarchar(20)
AS 
BEGIN
	DECLARE @MaPNCLT INT 
	EXEC @MaPNCLT= MergePhongNgayCa @TietBatDau = @TietBatDau, @NgayBatDau = @NgayBatDau, @NgayKetThuc = @NgayKetThuc, @Phong = @Phong, @ThuTrongTuan = @Thu
	DECLARE @Ma_CT_HKNH INT = (
	SELECT ID_CTHKNH FROM CT_HocKy_NamHoc
						RIGHT JOIN (SELECT MaNamHoc FROM NamHoc WHERE TenNamHoc = @NamHoc) AS NH ON CT_HocKy_NamHoc.MaNamHoc = NH.MaNamHoc
						RIGHT JOIN (SELECT * FROM HocKy WHERE TenHocKy = @HocKy) AS HK ON CT_HocKy_NamHoc.MaHocKy = HK.MaHocKy
	)
	UPDATE LopTinChi SET MaMH = @MaMH, ID_CTHKNH =  @Ma_CT_HKNH, MaPNCLyThuyet = @MaPNCLT, SoNhomTH = @SoNhomTH WHERE MaLopTC = @MaLopTC
	UPDATE TOP (1) DayLop SET MaGV = @MaGV1 WHERE DayLop.MaLopTC = @MaLopTC

	MERGE INTO Daylop AS TARGET
	USING (SELECT MaLTC = @MaLopTC, MaGV2 = @MaGV2) AS SOURCE
	ON (TARGET.MaLopTC = SOURCE.MaLTC and TARGET.MaGV != SOURCE.MaGV2 and TARGET.MaGV != @MaGV1)
	WHEN MATCHED THEN
	UPDATE SET MaGV = SOURCE.MaGV2 
	WHEN NOT MATCHED THEN
	INSERT (MaLopTC, MaGV) VALUES (@MaLopTC, SOURCE.MaGV2);
END
GO
/****** Object:  StoredProcedure [dbo].[UpdateGVByID]    Script Date: 3/13/2023 9:27:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UpdateGVByID] @MaGV NVARCHAR(20),  
@Ho NVARCHAR(20), @Tendem NVARCHAR(20), @Ten NVARCHAR(20), @NgaySinh DATE, @SoDienThoai_1 NVARCHAR(12),  
@SoDienThoai_2 NVARCHAR(12), @Email_1 NVARCHAR(50), @Email_2 NVARCHAR(50), @NghiLam BIT, @MaQQ INT, @GhiChu TEXT, @MaHocVi NVARCHAR(20)  
AS  
BEGIN  
UPDATE GiangVien SET Ho = @Ho, Tendem = @Tendem, Ten = @Ten, NgaySinh = @NgaySinh,  
SoDienThoai_1 = @SoDienThoai_1, SoDienThoai_2 = @SoDienThoai_2, Email_1 = @Email_1, Email_2 = @Email_2, NghiLam = @NghiLam, MaQQ = @MaQQ,  
GhiChu = @GhiChu, MaHocVi = @MaHocVi  
WHERE MaGV = @MaGV  
END
GO
/****** Object:  StoredProcedure [dbo].[UpdateMHByID]    Script Date: 3/13/2023 9:27:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UpdateMHByID] @MaMH NVARCHAR(20), @TenMH NVARCHAR(50), @SoTinChi int
AS  
BEGIN  
UPDATE MonHoc SET MaMH = @MaMH, TenMH = @TenMH, SoTinChi = @SoTinChi
WHERE MaMH = @MaMH  
END
GO
/****** Object:  StoredProcedure [dbo].[UpdateSVByID]    Script Date: 3/13/2023 9:27:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UpdateSVByID] @MaSV NVARCHAR(20),  
@Ho NVARCHAR(10), @Tendem NVARCHAR(10), @Ten NVARCHAR(10), @Phai bit, @NgaySinh DATE, @LopKhoaHoc NVARCHAR(20), @ChuongTrinhDaoTao NVARCHAR(20), @SoDienThoai_1 NVARCHAR(12),  
@SoDienThoai_2 NVARCHAR(12), @Email_1 NVARCHAR(50), @Email_2 NVARCHAR(50), @NghiHoc BIT, @MaNganh INT, @MaQQ INT 
AS  
BEGIN  
UPDATE SinhVien SET Ho = @Ho, Tendem = @Tendem, Ten = @Ten, Phai = @Phai, NgaySinh = @NgaySinh, LopKhoaHoc = @LopKhoaHoc, ChuongTrinhDaoTao = @ChuongTrinhDaoTao,
SoDienThoai_1 = @SoDienThoai_1, SoDienThoai_2 = @SoDienThoai_2, Email_1 = @Email_1, Email_2 = @Email_2, NghiHoc = @NghiHoc, MaNganh = @MaNganh, MaQQ = @MaQQ
WHERE MaSV = @MaSV  
END
GO
/****** Object:  StoredProcedure [dbo].[XemLichHoc]    Script Date: 3/13/2023 9:27:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[XemLichHoc]
@maSV nvarchar(20)
AS
BEGIN
SELECT MH.TenMH, TietBatDau, Phong, CTN.MaNhom, ThuTrongTuan, NgayBatDau, NgayKetThuc 
FROM DangKy AS DK INNER JOIN CT_Nhom AS CTN ON DK.IDCTN = CTN.IDCTN
				  INNER JOIN LopTinChi AS LTC ON CTN.MaLopTC = LTC.MaLopTC
				  INNER JOIN MonHoc AS MH ON LTC.MaMH = MH.MaMH
				  INNER JOIN Lich AS L ON LTC.MaLopTC = L.MaLopTC
				  INNER JOIN Phong_Ngay_Ca AS PNC ON L.MaPNC = PNC.MaPNC
				 WHERE DK.MaSV = @maSV
END
GO
/****** Object:  StoredProcedure [dbo].[XoaLopDangKy]    Script Date: 3/13/2023 9:27:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[XoaLopDangKy]
@maSV nvarchar(20),
@maMH nvarchar(20), 
@nhom int,
@tietBD int,
@ThuTrongTuan int,
@ngayBD nvarchar(10),
@phong nvarchar(10),
@ID_CTHKNH int
AS
BEGIN
	DECLARE @malop  nvarchar(20) = (SELECT LTC.MaLopTC FROM 
									(SELECT MaLopTC, MaMH, MaPNCLyThuyet FROM LopTinChi WHERE ID_CTHKNH = @ID_CTHKNH) AS LTC 
									 INNER JOIN (SELECT MaNhom, MaLopTC FROM CT_Nhom) AS CTN ON CTN.MaLopTC = LTC.MaLopTC
									 INNER JOIN (SELECT MaPNC, NgayBatDau, NgayKetThuc, TietBatDau, ThuTrongTuan, Phong FROM Phong_Ngay_Ca) PNC on LTC.MaPNCLyThuyet = PNC.MaPNC
		
									WHERE MaMH = MaMH AND TietBatDau = @tietBD AND Phong = @phong AND ThuTrongTuan = @ThuTrongTuan AND CTN.MaNhom = @nhom) 

	DECLARE @IDCTN INT = (SELECT IDCTN FROM CT_Nhom  WHERE MaLopTC = @malop AND MaNhom = @nhom)

	DELETE FROM DangKy WHERE MaSV = @maSV AND IDCTN = @IDCTN
	UPDATE CT_Nhom SET SoLuongDaDK = SoLuongDaDK - 1 WHERE MaLopTC = @malop AND IDCTN = @IDCTN
	
END
GO
