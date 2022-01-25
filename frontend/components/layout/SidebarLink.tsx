import React, {FC} from "react";
import Link from "next/link"

declare interface SidebarLinkProps {
    icon?: React.ReactNode;
    title: string,
    pathName: string,
    link: string,
}

const isLinkActive = (pathName: string, link: string) => {
    if (link === "/") {
        return pathName === "/";
    }
    return pathName.startsWith(link)
}

const SidebarLink: FC<SidebarLinkProps> = ({icon, title, link, pathName}) => {

    return (
        <li className="group relative py-2 px-5">
            <Link href={link} passHref={true}>
                <a className="font-ubuntu transition-colors duration-150">
                    {isLinkActive(pathName, link) ? (
                        <>
                            <div className="absolute inset-y-0 left-0 w-1 bg-blue-400 rounded-tr-lg rounded-br-lg" aria-hidden="true"/>
                            <span className="inline-flex items-center w-full text-gray-900 cursor-pointer">
                                {icon}
                                <span className="ml-2 font-avenir">
                                    {title}
                                </span>
                            </span>
                        </>
                    ) : (
                        <span className="inline-flex items-center w-full text-gray-400 group-hover:text-gray-700 cursor-pointer">
                            {icon}
                                <span className="ml-2 font-avenir">
                                {title}
                            </span>
                        </span>
                    )}
               </a>
            </Link>
        </li>
    )
}

export default SidebarLink
